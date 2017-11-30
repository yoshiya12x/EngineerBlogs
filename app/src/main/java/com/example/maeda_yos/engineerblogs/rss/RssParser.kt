package com.example.maeda_yos.engineerblogs.rss

import android.content.Context
import android.support.v7.widget.RecyclerView
import com.example.maeda_yos.engineerblogs.adapter.RecyclerAdapter
import com.prof.rssparser.Article
import com.prof.rssparser.Parser
import com.example.maeda_yos.engineerblogs.listener.OnRecyclerListener

/**
 * Created by maeda-yos on 2017/11/18.
 */

class RssParser(url: String) {

    private var url = ""

    init {
        this.url = url
    }

    fun setContents(context: Context, onRecyclerListener: OnRecyclerListener, recyclerView: RecyclerView){
        val rssParser = Parser()
        rssParser.execute(url)
        rssParser.onFinish(object : Parser.OnTaskCompleted{
            override fun onTaskCompleted(list: ArrayList<Article>) {
                val recyclerAdapter = RecyclerAdapter(context, list, onRecyclerListener)
                recyclerView.adapter = recyclerAdapter
            }

            override fun onError() {
                //what to do in case of error
            }

        })
    }
}