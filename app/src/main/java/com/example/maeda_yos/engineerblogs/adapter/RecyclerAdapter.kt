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
import com.example.maeda_yos.engineerblogs.util.NextPageUtil
import com.prof.rssparser.Article

@Suppress("CAST_NEVER_SUCCEEDS")

/**
 * Created by maeda-yos on 2017/11/19.
 */

class RecyclerAdapter(context: Context, articles: ArrayList<Article>, listener: OnRecyclerListener, blogTitle: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var inflater: LayoutInflater? = null
    private var context: Context? = null
    private var articles: ArrayList<Article>? = null
    private var listener: OnRecyclerListener? = null
    private var blogTitle: Int = 0

    init {
        this.inflater = LayoutInflater.from(context)
        this.context = context
        this.articles = articles
        this.listener = listener
        this.blogTitle = blogTitle
    }

    override fun getItemViewType(position: Int): Int {
        return if (this.articles!!.size > position) {
            0 // 通常のブログ記事パターン
        } else {
            1 // 2ページ目以降のWebViewパターン
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder?.itemViewType == 0) {
            val contentArticle = this.articles!![position]
            val title = if (contentArticle.title != null) {
                contentArticle.title
            } else {
                ""
            }
            val author = if (contentArticle.author != null) {
                contentArticle.author
            } else {
                ""
            }
            val description = if (contentArticle.description != null) {
                contentArticle.description
            } else {
                ""
            }
            val link = if (contentArticle.link != null) {
                contentArticle.link
            } else {
                ""
            }
            val blogArticle = BlogArticle(
                    title,
                    author,
                    description
            )
            val tempHolder: BlogViewHolder = holder as BlogViewHolder
            tempHolder.bind(blogArticle)
            tempHolder.itemView?.setOnClickListener { v ->
                listener?.onRecyclerViewClick(v, link, title)
            }
        } else {
            val blogArticle = BlogArticle(
                    "",
                    "",
                    ""
            )
            val tempHolder: NextPageViewHolder = holder as NextPageViewHolder
            tempHolder.bind(blogArticle)
            holder.itemView?.setOnClickListener { v ->
                val nextPageUtil = NextPageUtil()
                listener?.onRecyclerViewClick(v, nextPageUtil.getNextUrl(blogTitle), nextPageUtil.getNextTitle(blogTitle))
            }
        }
    }

    override fun getItemCount(): Int = articles!!.size + 1

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)

        if (viewType == 0) {
            val binding: ViewDataBinding =
                    DataBindingUtil.inflate(layoutInflater, R.layout.article_item, parent, false)
            return BlogViewHolder(binding)
        }

        val binding: ViewDataBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.article_next_page_item, parent, false)
        return NextPageViewHolder(binding)
    }

    class BlogViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: BlogArticle) {
            binding.setVariable(1, data)
            binding.executePendingBindings()
        }
    }

    class NextPageViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: BlogArticle) {
            binding.setVariable(1, data)
            binding.executePendingBindings()
        }
    }

}