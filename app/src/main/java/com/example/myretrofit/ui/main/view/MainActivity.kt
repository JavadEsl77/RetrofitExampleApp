package com.example.myretrofit.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myretrofit.R
import com.example.myretrofit.databinding.ActivityMainBinding
import com.example.myretrofit.ui.main.adapter.CountryListAdapter
import com.example.myretrofit.ui.main.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var bindingMain: ActivityMainBinding
    lateinit var recyclerViewAdapter: CountryListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = DataBindingUtil.setContentView(this, R.layout.activity_main)

        bindingMain.recListCountry
        initRecyclerView()
        initViewModel()

    }

    fun initRecyclerView() {
        bindingMain.recListCountry.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = CountryListAdapter(this)
        bindingMain.recListCountry.adapter = recyclerViewAdapter
    }

    private fun initViewModel() {
        val viewModel: MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null) {
                recyclerViewAdapter.setCountryList(it)
                recyclerViewAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "error get list", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeAPICall()
    }

}