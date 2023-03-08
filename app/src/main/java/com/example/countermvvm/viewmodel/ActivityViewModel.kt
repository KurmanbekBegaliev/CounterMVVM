package com.example.countermvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countermvvm.CountModel
import com.example.countermvvm.Event
import com.example.countermvvm.repository.Repository

class ActivityViewModel : ViewModel() {

    private val repository = Repository()

    fun increment(count: String): LiveData<CountModel> {
        return repository.increment(count)
    }

    fun decrement(count: String): LiveData<CountModel> {
        return repository.decrement(count)
    }



}