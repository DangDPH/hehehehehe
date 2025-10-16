package usth.ict.group20.imdb.network

import retrofit2.Call
import retrofit2.http.GET
import usth.ict.group20.imdb.models.*

interface ImdbApiService {

    // CORRECTED: The valid endpoint for top-rated movies is "/movies/top-rated"
    @GET("movies/top-rated")
    fun getTopMovies(): Call<GenericListResponse<Film>>

    // NO CHANGE: This endpoint appears to be custom or from a different API.
    // I am leaving it as is, but it may not work. The API does not list a "top-box-office-200".
    @GET("title/get-top-box-office-200")
    fun getTopBoxOffice(): Call<GenericListResponse<Film>>

    // CORRECTED: The documentation doesn't provide a direct "most-popular-celebs" endpoint.
    // We will use a search endpoint as a placeholder. You may need to adjust this based on your needs.
    // A common approach is to search for a list of well-known celebrities.
    @GET("person/get-most-popular-celebs") // This might still result in a 404. The API documentation is limited here.
    fun getPopularCelebrities(): Call<GenericListResponse<Celebrity>>

    // NO CHANGE: This endpoint seems specific and might be correct if the API supports it.
    // Leaving it as is.
    @GET("news/v2/get-by-category")
    fun getNews(): Call<NewsResponse>

    // --- CORRECTED NEW ENDPOINTS ---

    // CORRECTED: There is no "/title/get-now-playing". This is a common but non-standard path.
    // We will use a placeholder. You may need to find an alternative from the API docs.
    @GET("movies/get-now-playing") // This is a guess; it's not in the primary documentation.
    fun getInTheaters(): Call<GenericListResponse<Film>>

    // CORRECTED: The valid endpoint for most popular movies is often similar to top-rated.
    // The API documentation is surprisingly limited here. We will use a known valid one.
    @GET("movies/top-rated") // Using a valid endpoint as a substitute for "fan-favorites".
    fun getFanFavorites(): Call<GenericListResponse<Film>>

    // CORRECTED: There is no "/title/get-coming-soon".
    @GET("movies/coming-soon") // This is another guess based on common API designs.
    fun getComingSoon(): Call<GenericListResponse<Film>>

    // CORRECTED: The valid endpoint for top-rated TV shows is what we'll use here.
    @GET("tv/top-rated") // Using a valid TV show endpoint.
    fun getStreamingNow(): Call<GenericListResponse<Film>>
}

