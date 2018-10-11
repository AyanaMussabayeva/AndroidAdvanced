package com.example.amanzholt.lesson4

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(var context: Context, var dataset: ArrayList<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item, parent, false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val news = dataset[position]

        holder.itemView.titleText.text = news.title
        holder.itemView.dateText.text = news.date
    }

    inner class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view)
}