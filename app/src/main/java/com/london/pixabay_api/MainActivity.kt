package com.london.pixabay_api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.london.pixabay_api.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var imageAdapter=ImageAdapter(mutableListOf())
    var page=1
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        with(binding){
            changePageBtn.setOnClickListener{
                doRequest(++page)
            }
            searchBtn.setOnClickListener {
                doRequest(page)
            }
            recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView.canScrollVertically(1)) {
                        doRequest(++page)


                    }
                }
            })
        }
    }

    private fun ActivityMainBinding.doRequest(page:Int) {
        App.api.getImages(keyWord = keyWordEd.text.toString(), page = page)
            .enqueue(object : Callback<PixModel> {
                override fun onResponse(call: Call<PixModel>, response: Response<PixModel>) {
                    if (response.isSuccessful) {
                        response.body()?.hits.let {
                            imageAdapter = ImageAdapter(it)
                            binding.recycler.adapter = imageAdapter
                        }
                    }
                }

                override fun onFailure(call: Call<PixModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }
}