package com.example.maeda_yos.engineerblogs.fragment

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.maeda_yos.engineerblogs.R
import com.example.maeda_yos.engineerblogs.activity.ArticleActivity
import com.example.maeda_yos.engineerblogs.listener.EndlessScrollListener
import com.example.maeda_yos.engineerblogs.listener.OnRecyclerListener
import com.example.maeda_yos.engineerblogs.model.UserViewModel
import com.example.maeda_yos.engineerblogs.rss.RssParser
import com.ogaclejapan.smarttablayout.utils.v4.Bundler
import define.BlogUrls

/**
 * Created by maeda-yos on 2017/11/12.
 */

class BlogFragment : Fragment(), OnRecyclerListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rssParser: RssParser
    private var blogTitle = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // study test
        val userA = ViewModelProviders.of(this).get(UserViewModel::class.java)
        val userB = ViewModelProviders.of(activity).get(UserViewModel::class.java)
        val userC = ViewModelProviders.of(this).get(UserViewModel::class.java)

        val keyParam = arguments.getInt("keyParam")
        this.blogTitle = keyParam
        val url = BlogUrls().blogNames[keyParam]!!
        this.rssParser = RssParser(url)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.content_blog, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.addOnScrollListener(object : EndlessScrollListener(recyclerView.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(currentPage: Int) {
//                rssParser.setNextPage()
            }
        })

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rssParser.setContents(activity, this, recyclerView, blogTitle)
    }

    override fun onRecyclerViewClick(view: View, url: String, title: String) {
        val intent = Intent(this.context, ArticleActivity::class.java)
        intent.putExtra("url", url)
        intent.putExtra("title", title)
        startActivity(intent)
    }

    companion object {
        fun arguments(param: Int): Bundle {
            return Bundler()
                    .putInt("keyParam", param)
                    .get()
        }
    }
}
