package usth.ict.group20.imdb.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import usth.ict.group20.imdb.R
import usth.ict.group20.imdb.models.*
import usth.ict.group20.imdb.adapters.*
import usth.ict.group20.imdb.network.ImdbApiService
import usth.ict.group20.imdb.network.RetrofitClient

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private val scrollHandler = Handler(Looper.getMainLooper())
    private lateinit var scrollRunnable: Runnable
    private var carouselItemCount = 0
    private val apiService: ImdbApiService by lazy { RetrofitClient.instance }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // These functions do not make API calls, so they are safe here.
        setupSearch()
        setupFollowIMDbon()

        // Load all data from a single, organized function.
        loadCarousel()
    }

    private fun loadCarousel() {
        // --- START THE CHAIN: Call #1: Get Top Movies ---
        apiService.getTopMovies().enqueue(createApiCallback(
            onSuccess = { topMovies ->
                // --- 1. Use the data ---
                setupFeaturedCarousel(topMovies)
                setupHorizontalRecyclerView(R.id.top_10_recyclerview, FilmAdapter(topMovies.take(10)))
                setupHorizontalRecyclerView(R.id.oscar_winners_recyclerview, FilmAdapter(topMovies))

                // --- 2. Trigger the next call in the chain ---
                loadFanFavorites()
            },
            onFailureMessage = "Failed to load Top Movies"
        ))
    }

    private fun loadFanFavorites() {
        // --- Call #2: Get Fan Favorites ---
        apiService.getFanFavorites().enqueue(createApiCallback(
            onSuccess = { fanFavorites ->
                // --- 1. Use the data ---
                setupHorizontalRecyclerView(R.id.top_picks_recyclerview, FilmAdapter(fanFavorites))
                setupHorizontalRecyclerView(R.id.fans_favorites_recyclerview, FilmAdapter(fanFavorites))

                // --- 2. Trigger the next call ---
                loadInTheaters()
            },
            onFailureMessage = "Failed to load Fan Favorites"
        ))
    }

    private fun loadInTheaters() {
        // --- Call #3: Get "In Theaters" ---
        apiService.getInTheaters().enqueue(createFilmApiCallback(
            R.id.in_theaters_recyclerview,
            "Failed to load In Theaters",
            onSuccessExtra = {
                // --- Trigger the next call ---
                loadStreamingNow()
            }
        ))
    }

    private fun loadStreamingNow() {
        // --- Call #4: Get "Streaming Now" ---
        apiService.getStreamingNow().enqueue(createFilmApiCallback(
            R.id.streaming_now_recyclerview,
            "Failed to load Streaming Now",
            onSuccessExtra = {
                // --- Trigger the next call ---
                loadTopBoxOffice()
            }
        ))
    }

    private fun loadTopBoxOffice() {
        // --- Call #5: Get "Top Box Office" ---
        apiService.getTopBoxOffice().enqueue(createFilmApiCallback(
            R.id.top_box_office_recyclerview,
            "Failed to load Top Box Office",
            onSuccessExtra = {
                // --- Trigger the next call ---
                loadComingSoon()
            }
        ))
    }

    private fun loadComingSoon() {
        // --- Call #6: Get "Coming Soon" ---
        apiService.getComingSoon().enqueue(createFilmApiCallback(
            R.id.coming_soon_recyclerview,
            "Failed to load Coming Soon",
            onSuccessExtra = {
                // --- Trigger the next call ---
                setupFeaturedToday() // This function makes its own API call
            }
        ))
    }

    private fun setupFeaturedCarousel(films: List<Film>) {
        viewPager = findViewById(R.id.featured_carousel_viewpager)
        val topFilms = films.take(5) // Take the first 5 films for the carousel
        val carouselItems = topFilms.map { film ->
            CarouselItems(
                name = film.title,
                imageUrl = film.posterUrl,
                filmId = film.id
            )
        }
        carouselItemCount = carouselItems.size
        viewPager.adapter = CarouselAdapter(carouselItems)

        if (carouselItemCount > 1) {
            setupAutoScroll()
        }
    }

    private fun setupAutoScroll() {
        scrollRunnable = Runnable {
            viewPager.currentItem = (viewPager.currentItem + 1) % carouselItemCount
        }
        startAutoScroll()
    }

    private fun startAutoScroll() {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                scrollHandler.removeCallbacks(scrollRunnable)
                scrollHandler.postDelayed(scrollRunnable, 3500)
            }
        })
        scrollHandler.postDelayed(scrollRunnable, 3500)
    }

    override fun onPause() {
        super.onPause()
        if (::scrollRunnable.isInitialized) {
            scrollHandler.removeCallbacks(scrollRunnable)
        }
    }

    override fun onResume() {
        super.onResume()
        if (::scrollRunnable.isInitialized) {
            scrollHandler.postDelayed(scrollRunnable, 3500)
        }
    }

    private fun setupSearch() {
        val searchView: SearchView = findViewById(R.id.home_search_view)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrBlank()) {
                    Toast.makeText(this@MainActivity, "Searching for: $query", Toast.LENGTH_SHORT).show()
                    searchView.clearFocus()
                }
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }

    private fun setupFeaturedToday() {
        apiService.getNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    val newsList = response.body()?.data?.news?.items ?: emptyList()
                    findViewById<RecyclerView>(R.id.featured_today_recyclerview).apply {
                        layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                        adapter = NewsArticleAdapter(newsList)
                    }
                } else {
                    handleApiError("Failed to load news", response.code())
                }
            }
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                handleApiFailure("Failed to load news", t)
            }
        })
    }

    private fun setupBornToday() {
        apiService.getPopularCelebrities().enqueue(createApiCallback(
            onSuccess = { celebs -> setupHorizontalRecyclerView(R.id.born_today_recyclerview, CelebrityAdapter(celebs)) },
            onFailureMessage = "Failed to load born today"
        ))
    }

    private fun setupExploreMoviesLists() {
        apiService.getStreamingNow().enqueue(createFilmApiCallback(R.id.streaming_now_recyclerview, "Failed to load Streaming Now"))
        apiService.getTopBoxOffice().enqueue(createFilmApiCallback(R.id.top_box_office_recyclerview, "Failed to load Top Box Office"))
        apiService.getComingSoon().enqueue(createFilmApiCallback(R.id.coming_soon_recyclerview, "Failed to load Coming Soon"))
    }

    private fun setupFollowIMDbon() {
        findViewById<ImageButton>(R.id.btn_social_facebook).setOnClickListener { openUrl("https://www.facebook.com/imdb") }
        findViewById<ImageButton>(R.id.btn_social_twitter).setOnClickListener { openUrl("https://www.twitter.com/imdb") }
        findViewById<ImageButton>(R.id.btn_social_instagram).setOnClickListener { openUrl("https://www.instagram.com/imdb") }
        findViewById<ImageButton>(R.id.btn_social_tiktok).setOnClickListener { openUrl("https://www.tiktok.com/@imdb") }
        findViewById<ImageButton>(R.id.btn_social_youtube).setOnClickListener { openUrl("https://www.youtube.com/@imdb") }
    }

    private fun setupHorizontalRecyclerView(recyclerViewId: Int, adapter: RecyclerView.Adapter<*>) {
        findViewById<RecyclerView>(recyclerViewId).apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            this.adapter = adapter
        }
    }

    // START: MODIFIED CODE
    private fun createFilmApiCallback(
        recyclerViewId: Int,
        failureMessage: String,
        onSuccessExtra: (() -> Unit)? = null // Made this parameter nullable with a default value
    ): Callback<GenericListResponse<Film>> {
        return createApiCallback(
            onSuccess = { films ->
                setupHorizontalRecyclerView(recyclerViewId, FilmAdapter(films))
            },
            onFailureMessage = failureMessage,
            onSuccessExtra = onSuccessExtra // Pass it along
        )
    }

    private fun <T> createApiCallback(
        onSuccess: (List<T>) -> Unit,
        onFailureMessage: String,
        onSuccessExtra: (() -> Unit)? = null // Added the new nullable lambda parameter
    ): Callback<GenericListResponse<T>> {
        return object : Callback<GenericListResponse<T>> {
            override fun onResponse(call: Call<GenericListResponse<T>>, response: Response<GenericListResponse<T>>) {
                if (response.isSuccessful) {
                    onSuccess(response.body()?.data ?: emptyList())
                    onSuccessExtra?.invoke() // Execute the extra action if it's not null
                } else {
                    handleApiError(onFailureMessage, response.code())
                }
            }
            override fun onFailure(call: Call<GenericListResponse<T>>, t: Throwable) {
                handleApiFailure(onFailureMessage, t)
            }
        }
    }
    // END: MODIFIED CODE

    private fun handleApiError(message: String, code: Int) {
        Toast.makeText(this, "$message (Error: $code)", Toast.LENGTH_SHORT).show()
    }

    private fun handleApiFailure(message: String, t: Throwable) {
        Toast.makeText(this, "$message: ${t.message}", Toast.LENGTH_LONG).show()
    }

    private fun openUrl(url: String) {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        } catch (e: Exception) {
            Toast.makeText(this, "Could not open link", Toast.LENGTH_SHORT).show()
        }
    }
}
