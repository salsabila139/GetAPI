package com.salsabila.idn.getapi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.salsabila.idn.getapi.model.ResultsItem

class NewsAdapter (val dataArtikel : List<ResultsItem?>?)
    : RecyclerView.Adapter<NewsAdapter.MyViewHolder> () {   // <-Setelah ketik ini Alt+Enter di NewsAdapter dan pilih tiga2nya

        class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val imgJudul = view.findViewById<ImageView>(R.id.item_image_blog)
            val tvJudul = view.findViewById<TextView>(R.id.item_tv_judul)
            val tvPenulis = view.findViewById<TextView>(R.id.item_tv_penulis)
            val tvTanggal = view.findViewById<TextView>(R.id.item_tv_tanggal)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_news, parent, false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: NewsAdapter.MyViewHolder, position: Int) {
            holder.tvJudul.text = dataArtikel?.get(position)?.title
            holder.tvTanggal.text = dataArtikel?.get(position)?.pubDate
            holder.tvPenulis.text = dataArtikel?.get(position)?.sourceId

            Glide.with(holder.itemView)
                .load(dataArtikel?.get(position)?.imageUrl)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imgJudul)

            //dibawh ini ditambahin untuk klik bolog yang dipih dan bakalan di intent / fokus aja dulu ama tampilin data blog di display
            //karena ini bukan halaman activity maka kita butuh bantuan context untuk mengintent
            val context = holder.itemView.context
//            holder.itemView.setOnClickListener {
//                val intent = Intent(context, DetailBlogActivity::class.java)
//                intent.putExtra("detail", dataArtikel?.get(position))
//                context.startActivity(intent)
//            }
        }

        override fun getItemCount(): Int {
            if (dataArtikel != null){
                return  dataArtikel.size
            }
            return 0
        }

    }