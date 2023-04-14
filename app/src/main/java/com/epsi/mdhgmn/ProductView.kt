package com.epsi.mdhgmn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductView : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_view)

        // Retrieve the extras from the intent
        val pictureUrl = intent.getStringExtra("picture_url")
        val description = intent.getStringExtra("decription")
        val name = intent.getStringExtra("name")

        showBack()
        setHeaderTitle(name)

        // Find the UI elements
        val productImage: ImageView = findViewById(R.id.product_image)
        val productDescription: TextView = findViewById(R.id.product_description)

        // Load the image using Picasso
        Picasso.get().load(pictureUrl).into(productImage)

        // Set the text for the TextViews
        productDescription.text = description
    }
}