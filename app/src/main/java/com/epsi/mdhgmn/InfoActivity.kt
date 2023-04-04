package com.epsi.mdhgmn

import android.os.Bundle

class InfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infos)
        showBack()
        setHeaderTitle(getString(R.string.txt_title_infos))
    }
}