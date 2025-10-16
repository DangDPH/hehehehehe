package usth.ict.group20.imdb.ui.activity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JN\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00130\u0012\"\u0004\b\u0000\u0010\u00142\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001cH\u0002J6\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00130\u00122\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001a2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001cH\u0002J\u0018\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\nH\u0002J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010\'\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\b\u0010)\u001a\u00020\u0018H\u0002J\b\u0010*\u001a\u00020\u0018H\u0002J\b\u0010+\u001a\u00020\u0018H\u0002J\b\u0010,\u001a\u00020\u0018H\u0002J\u0012\u0010-\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\b\u00100\u001a\u00020\u0018H\u0014J\b\u00101\u001a\u00020\u0018H\u0014J\u0010\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u001aH\u0002J\b\u00104\u001a\u00020\u0018H\u0002J\b\u00105\u001a\u00020\u0018H\u0002J\b\u00106\u001a\u00020\u0018H\u0002J\u0016\u00107\u001a\u00020\u00182\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0017H\u0002J\b\u00109\u001a\u00020\u0018H\u0002J\b\u0010:\u001a\u00020\u0018H\u0002J\u001c\u0010;\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\n2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030=H\u0002J\b\u0010>\u001a\u00020\u0018H\u0002J\b\u0010?\u001a\u00020\u0018H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lusth/ict/group20/imdb/ui/activity/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "apiService", "Lusth/ict/group20/imdb/network/ImdbApiService;", "getApiService", "()Lusth/ict/group20/imdb/network/ImdbApiService;", "apiService$delegate", "Lkotlin/Lazy;", "carouselItemCount", "", "scrollHandler", "Landroid/os/Handler;", "scrollRunnable", "Ljava/lang/Runnable;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "createApiCallback", "Lretrofit2/Callback;", "Lusth/ict/group20/imdb/models/GenericListResponse;", "T", "onSuccess", "Lkotlin/Function1;", "", "", "onFailureMessage", "", "onSuccessExtra", "Lkotlin/Function0;", "createFilmApiCallback", "Lusth/ict/group20/imdb/models/Film;", "recyclerViewId", "failureMessage", "handleApiError", "message", "code", "handleApiFailure", "t", "", "loadCarousel", "loadComingSoon", "loadFanFavorites", "loadInTheaters", "loadStreamingNow", "loadTopBoxOffice", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "openUrl", "url", "setupAutoScroll", "setupBornToday", "setupExploreMoviesLists", "setupFeaturedCarousel", "films", "setupFeaturedToday", "setupFollowIMDbon", "setupHorizontalRecyclerView", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setupSearch", "startAutoScroll", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.viewpager2.widget.ViewPager2 viewPager;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler scrollHandler = null;
    private java.lang.Runnable scrollRunnable;
    private int carouselItemCount = 0;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy apiService$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final usth.ict.group20.imdb.network.ImdbApiService getApiService() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadCarousel() {
    }
    
    private final void loadFanFavorites() {
    }
    
    private final void loadInTheaters() {
    }
    
    private final void loadStreamingNow() {
    }
    
    private final void loadTopBoxOffice() {
    }
    
    private final void loadComingSoon() {
    }
    
    private final void setupFeaturedCarousel(java.util.List<usth.ict.group20.imdb.models.Film> films) {
    }
    
    private final void setupAutoScroll() {
    }
    
    private final void startAutoScroll() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void setupSearch() {
    }
    
    private final void setupFeaturedToday() {
    }
    
    private final void setupBornToday() {
    }
    
    private final void setupExploreMoviesLists() {
    }
    
    private final void setupFollowIMDbon() {
    }
    
    private final void setupHorizontalRecyclerView(int recyclerViewId, androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
    }
    
    private final retrofit2.Callback<usth.ict.group20.imdb.models.GenericListResponse<usth.ict.group20.imdb.models.Film>> createFilmApiCallback(int recyclerViewId, java.lang.String failureMessage, kotlin.jvm.functions.Function0<kotlin.Unit> onSuccessExtra) {
        return null;
    }
    
    private final <T extends java.lang.Object>retrofit2.Callback<usth.ict.group20.imdb.models.GenericListResponse<T>> createApiCallback(kotlin.jvm.functions.Function1<? super java.util.List<? extends T>, kotlin.Unit> onSuccess, java.lang.String onFailureMessage, kotlin.jvm.functions.Function0<kotlin.Unit> onSuccessExtra) {
        return null;
    }
    
    private final void handleApiError(java.lang.String message, int code) {
    }
    
    private final void handleApiFailure(java.lang.String message, java.lang.Throwable t) {
    }
    
    private final void openUrl(java.lang.String url) {
    }
}