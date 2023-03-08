package com.example.countermvvm

data class CountModel(
    var numberState: String,
    var color: String,
    var msg: Event<String>? = null
)