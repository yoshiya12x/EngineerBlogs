package com.example.maeda_yos.engineerblogs.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.maeda_yos.engineerblogs.R
import com.example.maeda_yos.engineerblogs.listener.OnRecyclerListener
import com.example.maeda_yos.engineerblogs.model.BlogArticle
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
        var title = this.articles!![position].title
        var author = this.articles!![position].author
        var description = this.articles!![position].description
        val link = this.articles!![position].link
        if(title == null) title = ""
        if(author == null) author = ""
        if(description == null) description = ""

        val blogArticle = BlogArticle(
                title,
                author,
                description
        )
        holder?.bind(blogArticle)
        holder?.itemView?.setOnClickListener{ v ->
            listener?.onRecyclerViewClick(v, link, title)
        }
    }

    override fun getItemCount(): Int = articles!!.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding: ViewDataBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.article_item, parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: BlogArticle){
            binding.setVariable(1 ,data)
            binding.executePendingBindings()
        }
    }

}