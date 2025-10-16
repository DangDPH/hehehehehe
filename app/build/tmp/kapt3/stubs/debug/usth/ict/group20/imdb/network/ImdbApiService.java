package usth.ict.group20.imdb.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u0003H\'J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'\u00a8\u0006\u000f"}, d2 = {"Lusth/ict/group20/imdb/network/ImdbApiService;", "", "getComingSoon", "Lretrofit2/Call;", "Lusth/ict/group20/imdb/models/GenericListResponse;", "Lusth/ict/group20/imdb/models/Film;", "getFanFavorites", "getInTheaters", "getNews", "Lusth/ict/group20/imdb/models/NewsResponse;", "getPopularCelebrities", "Lusth/ict/group20/imdb/models/Celebrity;", "getStreamingNow", "getTopBoxOffice", "getTopMovies", "app_debug"})
public abstract interface ImdbApiService {
    
    @retrofit2.http.GET(value = "/title/get-top-rated-movies")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<usth.ict.group20.imdb.models.GenericListResponse<usth.ict.group20.imdb.models.Film>> getTopMovies();
    
    @retrofit2.http.GET(value = "/title/get-top-box-office-200")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<usth.ict.group20.imdb.models.GenericListResponse<usth.ict.group20.imdb.models.Film>> getTopBoxOffice();
    
    @retrofit2.http.GET(value = "/person/get-most-popular-celebs")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<usth.ict.group20.imdb.models.GenericListResponse<usth.ict.group20.imdb.models.Celebrity>> getPopularCelebrities();
    
    @retrofit2.http.GET(value = "/news/v2/get-by-category")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<usth.ict.group20.imdb.models.NewsResponse> getNews();
    
    @retrofit2.http.GET(value = "/title/get-now-playing")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<usth.ict.group20.imdb.models.GenericListResponse<usth.ict.group20.imdb.models.Film>> getInTheaters();
    
    @retrofit2.http.GET(value = "/title/get-most-popular-movies")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<usth.ict.group20.imdb.models.GenericListResponse<usth.ict.group20.imdb.models.Film>> getFanFavorites();
    
    @retrofit2.http.GET(value = "/title/get-coming-soon")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<usth.ict.group20.imdb.models.GenericListResponse<usth.ict.group20.imdb.models.Film>> getComingSoon();
    
    @retrofit2.http.GET(value = "/title/get-most-popular-tv-shows")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<usth.ict.group20.imdb.models.GenericListResponse<usth.ict.group20.imdb.models.Film>> getStreamingNow();
}