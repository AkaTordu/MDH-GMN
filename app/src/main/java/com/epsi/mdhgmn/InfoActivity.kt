package com.epsi.mdhgmn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class InfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infos)
        showBack()
        setHeaderTitle(getString(R.string.txt_title_infos))

        val buttonMax = findViewById<Button>(R.id.buttonMax)
        buttonMax.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, StudentActivity::class.java)
            val firstName = "Max"
            val lastName = "DELIBES-HOUDAYER"
            val email = "m.delibeshoudayer@epsi.fr"

            intent.putExtra("firstName", firstName)
            intent.putExtra("lastName", lastName)
            intent.putExtra("email", email)
            startActivity(intent)
        })

        val buttonGermain = findViewById<Button>(R.id.buttonGermain)
        buttonGermain.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, StudentActivity::class.java)
            val firstName = "Germain"
            val lastName = "LEIGNEL"
            val email = "germain.leignel@epsi.fr"

            intent.putExtra("firstName", firstName)
            intent.putExtra("lastName", lastName)
            intent.putExtra("email", email)
            startActivity(intent)
        })
    }
}
