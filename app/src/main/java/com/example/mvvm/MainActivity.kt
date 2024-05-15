package com.example.mvvm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.model.User

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModel
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.user.observe(this, Observer { user ->
            displayUserData(user)
        })
        viewModel.getUser()

        setContentView(binding.root)
    }

    private fun displayUserData(user: User?) {

        binding.text1.text = user?.name
        binding.text2.text = user?.email
    }

}