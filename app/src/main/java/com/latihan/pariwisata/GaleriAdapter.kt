package com.latihan.pariwisata

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.concurrent.CopyOnWriteArrayList

class GaleriAdapter(url: Array<String>, context: Context) :
        RecyclerView.Adapter<GaleriAdapter.ViewHolder>() {
    var context: Context
    var url: Array<String>
    init {
        this.context = context
        this.url =url
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        var v: View

        v =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_galeri_adapter, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return url.size

    }

    override fun onBindViewHolder(holder: GaleriAdapter.ViewHolder, position: Int) {
        Glide.with(context)
            .load(url.get(position))
            .into(holder.gambar)
    }
    class ViewHolder(itemView: View?) :
            RecyclerView.ViewHolder(itemView!!) {
        var gambar : ImageView
        init {
            gambar = itemView!!.findViewById(R.id.gambar)
        }
    }
}