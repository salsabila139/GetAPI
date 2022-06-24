package com.salsabila.idn.getapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.salsabila.idn.getapi.api.ApiConfig
import com.salsabila.idn.getapi.model.ResponseNews
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvError = findViewById<TextView>(R.id.tv_error)
        val rvBlog = findViewById<RecyclerView>(R.id.rv_blog)

        ApiConfig.getService().getNews().enqueue(object : Callback<ResponseNews> {
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                if (response.isSuccessful){
                    val responseBlog = response.body()
                    val msg = responseBlog?.status
                    val dataArtikel = responseBlog?.results

                    val blogAdapter = NewsAdapter(dataArtikel)

                    rvBlog.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        blogAdapter.notifyDataSetChanged()
                        adapter = blogAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                tvError.visibility = View.VISIBLE
                tvError.text = t.localizedMessage
            }
        })

    }
}
