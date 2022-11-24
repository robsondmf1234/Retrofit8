package com.example.retrofittutorial8

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofittutorial8.databinding.ActivityMainBinding
import com.example.retrofittutorial8.repository.Repository
import com.example.retrofittutorial8.viewmodel.MainViewModel
import com.example.retrofittutorial8.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initializeViewModel()
        observers()

    }

    private fun initializeViewModel() {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getPost()
    }


    private fun observers() {
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Response", response.body()?.userId.toString())
                binding.txtUserId.text = response.body()?.userId.toString()

                Log.d("Response", response.body()?.id.toString())
                binding.txtId.text = response.body()?.id.toString()

                Log.d("Response", response.body()?.body.toString())
                binding.txtBody.text = response.body()?.body.toString()

                Log.d("Response", response.body()?.title.toString())
                binding.txtTitle.text = response.body()?.title.toString()
            } else {
                Log.d("Response", response.errorBody().toString())
                binding.txtUserId.text = response.errorBody().toString()

            }
        })
    }
}