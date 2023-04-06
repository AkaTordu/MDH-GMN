package com.epsi.mdhgmn

import ProductAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

data class ProductItem(
    val name: String,
    val description: String,
    val picture_url: String
)


class ProductsActivity : BaseActivity() {

    private lateinit var productsRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produits)

        val title = intent.extras?.getString("title")
        val url = intent.extras?.getString("products_url").toString()

        productsRecyclerView = findViewById(R.id.productsRecyclerView)
        productsRecyclerView.layoutManager = LinearLayoutManager(this)

        showBack()
        setHeaderTitle(title)
        fetchData(url)
    }

    private fun fetchData(url: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    val jsonData = response.body!!.string()

                    val jsonObject = JSONObject(jsonData)
                    val itemsJson = jsonObject.getJSONArray("items").toString()

                    val gson = Gson()
                    val type = object : TypeToken<List<ProductItem>>() {}.type
                    val productItems: List<ProductItem> = gson.fromJson(itemsJson, type)

                    runOnUiThread {
                        displayCategories(productItems)
                    }
                }
            }
        })
    }

    private fun displayCategories(productItems: List<ProductItem>) {
        val adapter = ProductAdapter(productItems)
        productsRecyclerView.adapter = adapter
    }
}