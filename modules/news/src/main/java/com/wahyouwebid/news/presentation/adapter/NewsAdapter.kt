package com.wahyouwebid.news.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wahyouwebid.news.databinding.ItemNewsBinding
import com.wahyouwebid.news.domain.model.Article

class NewsAdapter (private val showDetail: (Article) -> Unit) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var data = listOf<Article>()

    fun setData(dataList: List<Article>) {
        data = dataList
        notifyItemInserted(data.lastIndex)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.view) {
            val item = data[position]
            tvTitle.text = item.title
            tvDescription.text = item.description
            Glide.with(ivThumbnail)
                .load(item.urlToImage)
                .into(ivThumbnail)
            root.setOnClickListener { showDetail.invoke(item) }
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    class ViewHolder(val view: ItemNewsBinding) : RecyclerView.ViewHolder(view.root)

}