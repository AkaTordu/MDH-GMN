import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.epsi.mdhgmn.*
import com.squareup.picasso.Picasso
import android.widget.ImageView
import android.widget.TextView

class ProductAdapter(private val productItems: List<ProductItem>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productButton: LinearLayout = itemView.findViewById(R.id.productButton)
        val productName = itemView.findViewById<TextView>(R.id.productName)
        val productDescription = itemView.findViewById<TextView>(R.id.productDescription)
        val productImage = itemView.findViewById<ImageView>(R.id.productImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productItem = productItems[position]

        holder.productName.text = productItem.name
        holder.productDescription.text = productItem.description

        Picasso.get().load(productItem.picture_url).into(holder.productImage)

        holder.productButton.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ProductView::class.java)
            intent.putExtra("picture_url", productItem.picture_url)
            intent.putExtra("decription", productItem.description)
            intent.putExtra("name", productItem.name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productItems.size
    }
}
