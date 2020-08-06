package com.skh.count

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.skh.count.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*

class viewmodelactivity2 : AppCompatActivity() {
    val shareFile ="SHARED_PREFERENCED"
    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    lateinit var countViewModel: CountViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodelactivity2)

        countViewModel = ViewModelProvider (this).get(CountViewModel:: class.java)
        sharedPreferences =this.getSharedPreferences(shareFile, Context.MODE_PRIVATE)
        editor =  sharedPreferences?.edit()

        var storeCount =  sharedPreferences?. getInt("COUNT", 0)
       text1.text = storeCount.toString()
        bottom.setOnClickListener {
            var count=text1.text.toString().toInt()
                countViewModel.setCount(count)
            text1.text=countViewModel.getCount().toString()

        }
    }
    override fun onPause(){
        super.onPause()
        editor?.putInt("COUNT",text1.text.toString().toInt()) // intent
        editor?.apply()
    }
}
