package com.epsi.mdhgmn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProductsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produits)
        showBack()
        setHeaderTitle(getString(R.string.txt_title_produits))
    }
}