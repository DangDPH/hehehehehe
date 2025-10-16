package usth.ict.group20.imdb.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import usth.ict.group20.imdb.BuildConfig // Import BuildConfig

object RetrofitClient {

    // The base URL for the API. The trailing slash is crucial for Retrofit.
    private const val BASE_URL = "https://imdb-movies-shows-persons-api.p.rapidapi.com/"

    // The host name for the API, used in the request header.
    private const val API_HOST = "imdb-movies-shows-persons-api.p.rapidapi.com"

    // Lazily create the OkHttpClient to add our interceptors.
    private val client: OkHttpClient by lazy {
        // This interceptor helps you see the full network request and response in Logcat.
        // It's extremely useful for debugging.
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY // See everything in debug builds
            } else {
                HttpLoggingInterceptor.Level.NONE // Don't log in release builds
            }
        }

        // The main interceptor to add the required RapidAPI headers to every request.
        // The main interceptor to add the required RapidAPI headers to every request.
        val authInterceptor = { chain: Interceptor.Chain -> // Specify the type here
            val request = chain.request().newBuilder()
                // Your personal API key.
                .addHeader("x-rapidapi-key", "5657c42ef4mshbb72166d6812d42p1d508cjsn0197decf4fa9")
                // The host header required by RapidAPI.
                .addHeader("x-rapidapi-host", API_HOST)
                .build()
            chain.proceed(request) // This is what the interceptor returns
        }


        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) // For debugging
            .addInterceptor(authInterceptor)    // For authentication
            .build()
    }

    // Lazily create the Retrofit instance using our custom client.
    val instance: ImdbApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client) // Use the OkHttpClient we configured above
            .build()
            .create(ImdbApiService::class.java)
    }
}