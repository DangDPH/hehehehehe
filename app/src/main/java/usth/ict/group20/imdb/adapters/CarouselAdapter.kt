package usth.ict.group20.imdb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import usth.ict.group20.imdb.R

// 1. This is the correct data class. It matches what MainActivity creates.
data class CarouselItems(
    val name: String,
    val imageUrl: String,
    val filmId: String
)

// The adapter now takes a list of the new CarouselItems
class CarouselAdapter(private val items: List<CarouselItems>) :
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    class CarouselViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.carousel_image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carousel, parent, false)
        return CarouselViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val item = items[position]

        // 2. This is the fix: Use the Glide library to load the image from the internet URL.
        Glide.with(holder.itemView.context)
            .load(item.imageUrl)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.drawable.error)
            .into(holder.imageView)
        //

        // You can add a click listener here to open the movie details later
        holder.itemView.setOnClickListener {
            // TODO: Handle click to go to the movie detail page using item.filmId
        }
    }

    override fun getItemCount(): Int = items.size
}

