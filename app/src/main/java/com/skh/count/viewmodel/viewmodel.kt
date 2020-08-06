package com.skh.count.viewmodel
import androidx.lifecycle.ViewModel
class CountViewModel : ViewModel(){
private var count : Int = 1 //2 / variable

fun getCount(): Int= count //getter

fun setCount(num : Int): Int {         //setter
    count= num+1
    return count

}
}
