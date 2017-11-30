package com.example.maeda_yos.engineerblogs.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.maeda_yos.engineerblogs.R
import com.example.maeda_yos.engineerblogs.listener.OnRecyclerListener
import com.example.maeda_yos.engineerblogs.util.RmpUtil
import com.prof.rssparser.Article
import com.squareup.picasso.Picasso

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
        System.out.println(rmpUtil.getImgUrl(this.articles!![position].description))
        Picasso.with(context).load(rmpUtil.getImgUrl(this.articles!![position].description)).resize(750, 300).into(holder!!.itemThumbnail)
        holder.itemText!!.text = this.articles!![position].link
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
        var itemThumbnail: ImageView? = null

        init {
            if (itemView != null) {
                itemText = itemView.findViewById(R.id.list_item_text)
                itemThumbnail = itemView.findViewById(R.id.list_item_thumbnail)
            }
        }
    }

}