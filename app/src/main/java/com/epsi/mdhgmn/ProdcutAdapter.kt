import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.epsi.mdhgmn.CategoryItem
import com.epsi.mdhgmn.ProductItem
import com.epsi.mdhgmn.ProductsActivity
import com.epsi.mdhgmn.R

class ProductAdapter(private val productItems: List<ProductItem>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productButton: Button = itemView.findViewById(R.id.productButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productItem = productItems[position]
        holder.productButton.text = productItem.name

        holder.productButton.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ProductsActivity::class.java)
            intent.putExtra("picture_url", productItem.picture_url)
            intent.putExtra("name", productItem.name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productItems.size
    }
}
