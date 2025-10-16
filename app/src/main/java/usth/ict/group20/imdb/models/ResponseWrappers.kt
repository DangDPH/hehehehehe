package usth.ict.group20.imdb.models

/**
 * A generic response wrapper for API calls that return a list of items
 * directly under a "data" key.
 * This class serves as the response model for both Film and Celebrity lists.
 *
 * @param T The type of data in the list (e.g., Film, Celebrity).
 * @property data The list of data items from the API response.
 */
data class GenericListResponse<T>(
    val data: List<T> = emptyList()
)

// --- Specific Response Wrappers for the Nested News API Structure ---

/**
 * This is the top-level response class for the news API endpoint.
 * It directly matches the JSON structure: { "data": { ... } }
 */
data class NewsResponse(
    val data: NewsData?
)

/**
 * Represents the "data" object within the news JSON response.
 * It matches the structure: { "data": { "news": { ... } } }
 */
data class NewsData(
    val news: NewsContainer?
)

/**
 * Represents the "news" object which contains the actual list of articles.
 * It matches the structure: { "data": { "news": { "items": [ ... ] } } }
 */
data class NewsContainer(
    val items: List<NewsArticle> = emptyList()
)

