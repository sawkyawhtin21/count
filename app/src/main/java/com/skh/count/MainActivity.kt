package com.skh.count

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.skh.count.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var countViewModel = ViewModelProvider(this).get(CountViewModel::class.java)
        text1.text = countViewModel.getCount().toString()

        bottom.setOnClickListener {
            var count=text1.text.toString().toInt()
            countViewModel.setCount(count)
            text1.text=countViewModel.getCount().toString()
        }


    }
}
