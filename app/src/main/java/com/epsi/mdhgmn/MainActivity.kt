package com.epsi.mdhgmn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setHeaderTitle(getString(R.string.txt_title_main))

        val buttonInfo = findViewById<Button>(R.id.buttonInfo)
        buttonInfo.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        })

        val buttonProduct = findViewById<Button>(R.id.buttonProducts)
        buttonProduct.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ProductsActivity::class.java)
            startActivity(intent)
        })
    }
}