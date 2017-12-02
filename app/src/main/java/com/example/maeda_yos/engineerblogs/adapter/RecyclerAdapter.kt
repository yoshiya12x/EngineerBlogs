package com.example.maeda_yos.engineerblogs.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.maeda_yos.engineerblogs.R
import com.example.maeda_yos.engineerblogs.listener.OnRecyclerListener
import com.example.maeda_yos.engineerblogs.util.RmpUtil
import com.prof.rssparser.Article

@Suppress("CAST_NEVER_SUCCEEDS")

/**
 * Created by maeda-yos on 2017/11/19.
 */

class RecyclerAdapter(context: Context, articles: ArrayList<Article>, listener: OnRecyclerListener) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var inflater: LayoutInflater? = null
    private var context: Context? = null
    private var articles: ArrayList<Article>? = null
    private var listener: OnRecyclerListener? = null

    init {
        this.inflater = LayoutInflater.from(context)
        this.context = context
        this.articles = articles
        this.listener = listener
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val rmpUtil = RmpUtil()
        holder!!.itemTitle!!.text = this.articles!![position].title
        holder.itemAuthor!!.text = this.articles!![position].author
        holder.itemText!!.text = this.articles!![position].description
    }

    override fun getItemCount(): Int = articles!!.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(this.inflater!!.inflate(
                R.layout.article_item,
                parent,
                false
        ))
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var itemText: TextView? = null
        var itemTitle: TextView? = null
        var itemAuthor: TextView? = null

        init {
            if (itemView != null) {
                itemText = itemView.findViewById(R.id.list_item_text)
                itemTitle = itemView.findViewById(R.id.list_item_title)
                itemAuthor = itemView.findViewById(R.id.list_item_author)
            }
        }
    }

}