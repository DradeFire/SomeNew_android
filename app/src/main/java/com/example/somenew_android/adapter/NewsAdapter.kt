package com.example.somenew_android.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.text.Html
import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.somenew_android.api.model.Article
import com.example.somenew_android.api.model.NewModel
import com.example.somenew_android.databinding.ItemNewBinding
import com.example.somenew_android.text_links.MakeLinksClicable

class NewsAdapter(new: NewModel, private val context: Context) : RecyclerView.Adapter<NewsAdapter.ItemViewHolder>() {

    private var newsList = new

    class ItemViewHolder(private val binding: ItemNewBinding)
        : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(new: Article, context: Context) = with(binding){
            txAuthor.text = "Author: ${new.author}"
            txTitle.text = new.title
            txSource.text = "Source: ${new.source.name}"
            txTime.text = new.publishedAt
            txDescr.text = new.description

            txReadNext.text = Html.fromHtml("<a href=\"${new.url}\" target=\"_blank\">Read</a>")
            txReadNext.linksClickable = true
            txReadNext.movementMethod = LinkMovementMethod.getInstance()
            val text: CharSequence = txReadNext.text
            if (text is Spannable) {
                txReadNext.text = MakeLinksClicable.reformatText(text)
            }

            Glide.with(context)
                .load(new.urlToImage)
                .centerCrop()
                .into(imNew)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemNewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = newsList.articles[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return newsList.articles.size
    }

}