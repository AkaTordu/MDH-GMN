package com.epsi.mdhgmn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("DevAI","####################### onCreate "+ javaClass.simpleName)
    }

    override fun onStart() {
        super.onStart()
        Log.e("DevAI","####################### onStart "+ javaClass.simpleName)
    }

    override fun onResume() {
        super.onResume()
        Log.e("DevAI","####################### onResume "+ javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()
        Log.e("DevAI","####################### onPause "+ javaClass.simpleName)
    }

    override fun onStop() {
        super.onStop()
        Log.e("DevAI","####################### onStop "+ javaClass.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("DevAI","####################### onDestroy "+ javaClass.simpleName)
    }

    fun setHeaderTitle( title:String?){
        val textViewTitle= findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.setText(title)
    }

    fun showBack(){
        val imageViewBack=findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility=View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

}