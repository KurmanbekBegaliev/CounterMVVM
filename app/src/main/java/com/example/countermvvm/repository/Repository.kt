package com.example.countermvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.countermvvm.Colors
import com.example.countermvvm.CountModel
import com.example.countermvvm.Event

class Repository {

    val liveData = MutableLiveData<CountModel> ()
    private val colors = Colors().colors
    private var color = colors[0]

    private val statusMessage = MutableLiveData<Event<String>>()

    val message : LiveData<Event<String>>
        get() = statusMessage

    fun increment(count: String): LiveData<CountModel> {
        return returnNumber(count.toInt() + 1)

    }

    fun decrement(count: String): LiveData<CountModel> {
        return returnNumber(count.toInt() - 1)
    }

    private fun returnNumber(num: Int): LiveData<CountModel> {
        var bool: Event<String>? = null

        if(num == 10) bool = Event("uraa")
        if (num == 15) {
            val x = (1..colors.size).random()
            color = colors[x-1]
        }

        liveData.postValue(
            CountModel(numberState = num.toString(), color = color, msg = bool)
        )
        return liveData
    }
}