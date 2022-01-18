package com.example.medapp.presentation.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.R
import com.example.medapp.domain.entity.News
import kotlinx.android.synthetic.main.news_item_view.view.*

class NewsAdapter(private val listOfNews: List<News>) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(listOfNews[position])
    }

    override fun getItemCount(): Int {
        return listOfNews.size
    }

}


class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(news: News) {
        itemView.news_component_name_text_view.text = news.description
    }
}
