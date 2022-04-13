package com.example.somenew_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.somenew_android.adapter.NewsAdapter
import com.example.somenew_android.databinding.ActivityMainBinding
import com.example.somenew_android.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        bindRc()

    }

    private fun bindRc() {
        viewModel.getNews()
        viewModel.news.observe(this){ response ->
            if(response.isSuccessful){

                binding.rcNews.apply {
                    adapter = NewsAdapter(response.body()!!, this@MainActivity)
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }

            } else {
                Toast.makeText(this, "Some problem!", Toast.LENGTH_LONG).show()
            }
        }
    }
}