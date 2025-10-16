package usth.ict.group20.imdb.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lusth/ict/group20/imdb/adapters/NewsArticleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lusth/ict/group20/imdb/adapters/NewsArticleAdapter$ArticleViewHolder;", "articles", "", "Lusth/ict/group20/imdb/models/NewsArticle;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ArticleViewHolder", "app_debug"})
public final class NewsArticleAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<usth.ict.group20.imdb.adapters.NewsArticleAdapter.ArticleViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<usth.ict.group20.imdb.models.NewsArticle> articles = null;
    
    public NewsArticleAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<usth.ict.group20.imdb.models.NewsArticle> articles) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public usth.ict.group20.imdb.adapters.NewsArticleAdapter.ArticleViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    usth.ict.group20.imdb.adapters.NewsArticleAdapter.ArticleViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lusth/ict/group20/imdb/adapters/NewsArticleAdapter$ArticleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "articleHeadline", "Landroid/widget/TextView;", "getArticleHeadline", "()Landroid/widget/TextView;", "articleImage", "Landroid/widget/ImageView;", "getArticleImage", "()Landroid/widget/ImageView;", "articleSource", "getArticleSource", "app_debug"})
    public static final class ArticleViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView articleImage = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView articleHeadline = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView articleSource = null;
        
        public ArticleViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getArticleImage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getArticleHeadline() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getArticleSource() {
            return null;
        }
    }
}