package usth.ict.group20.imdb.network

import retrofit2.Call
import retrofit2.http.GET
import usth.ict.group20.imdb.models.*

interface ImdbApiService {
    // Using a generic response type for cleaner callbacks
    @GET("/title/get-top-rated-movies")
    fun getTopMovies(): Call<GenericListResponse<Film>>

    @GET("/title/get-top-box-office-200")
    fun getTopBoxOffice(): Call<GenericListResponse<Film>>

    @GET("/person/get-most-popular-celebs")
    fun getPopularCelebrities(): Call<GenericListResponse<Celebrity>>

    // News has a different structure, so it keeps its own response model
    @GET("/news/v2/get-by-category")
    fun getNews(): Call<NewsResponse>

    // --- NEW ENDPOINTS TO FILL OUT THE UI ---
    // Note: These endpoints are assumed based on the UI.
    // You may need to replace them with the actual valid endpoints from the API documentation.

    @GET("/title/get-now-playing")
    fun getInTheaters(): Call<GenericListResponse<Film>>

    @GET("/title/get-most-popular-movies")
    fun getFanFavorites(): Call<GenericListResponse<Film>>

    @GET("/title/get-coming-soon")
    fun getComingSoon(): Call<GenericListResponse<Film>>

    @GET("/title/get-most-popular-tv-shows")
    fun getStreamingNow(): Call<GenericListResponse<Film>>
}

