package com.example.countermvvm.view

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.countermvvm.CountModel
import com.example.countermvvm.databinding.ActivityMainBinding
import com.example.countermvvm.repository.Repository
import com.example.countermvvm.viewmodel.ActivityViewModel

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        onClick()


    }

    private fun onClick() {
        binding.btnIncrement.setOnClickListener {
            viewModel.increment(binding.tvCounter.text.toString())
                .observe(this) {
                    changer(it)

                }
        }

        binding.btnDecrement.setOnClickListener {
            viewModel.decrement(binding.tvCounter.text.toString())
                .observe(this) {
                    changer(it)

                }
        }
    }

    private fun changer(model: CountModel){
        binding.tvCounter.text = model.numberState
        binding.tvCounter.setTextColor(Color.parseColor(model.color))
        model.msg?.let {
            //        Если здесь показать тост он дублировался, не знаю почему, пришлось сделать некрасивым путем
            Toast.makeText(this@MainActivity, "it.toString()", Toast.LENGTH_SHORT).show()
        }

//        здесь тоже
//        if (model.isTen) {
//            Toast.makeText(this@MainActivity, "Congratulation!!", Toast.LENGTH_SHORT).show()
//        }
//        Можете подсказать как правильно реализовать это
    }

}