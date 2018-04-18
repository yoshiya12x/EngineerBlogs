package com.example.maeda_yos.engineerblogs.util

import com.example.maeda_yos.engineerblogs.R

/**
 * Created by xjapan on 2017/12/24.
 */

class NextPageUtil {
    fun getNextUrl(blogTitle: Int): String {
        when (blogTitle) {
            R.string.recruit_mp -> return "https://tech.recruit-mp.co.jp/page/2/"
            R.string.eureka -> return "https://developers.eure.jp/page/2/"
            R.string.line -> return "https://engineering.linecorp.com/ja/blog/2/"
            R.string.techbooster -> return "https://techbooster.org/page/2/"
            R.string.azure -> return "http://azure.sios.jp/"
            R.string.recruit_tech -> return "http://atl.recruit-tech.co.jp/blog/page/2/"
            R.string.android -> return "https://blog.google/products/android/"
            R.string.lancers -> return "https://engineer.blog.lancers.jp/page/2/"
            R.string.dwango -> return "http://ch.nicovideo.jp/dwango-engineer/blomaga?page=2"
            R.string.smartnews -> return "https://developer.smartnews.com/blog/page/2/"
            R.string.increments -> return "http://blog.qiita.com/page/2"
            R.string.recruit_jobs -> return "https://techblog.recruitjobs.net/"
        }
        return ""
    }

    fun getNextTitle(blogTitle: Int): String {
        when (blogTitle) {
            R.string.recruit_mp -> return "リクルートマーケティングパートナーズ"
            R.string.eureka -> return "エウレカ"
            R.string.line -> return "LINE"
            R.string.techbooster -> return "TECHBOOSTER"
            R.string.azure -> return "Azure"
            R.string.recruit_tech -> return "リクルートテクノロジーズ"
            R.string.android -> return "Android official"
            R.string.lancers -> return "Lancers"
            R.string.dwango -> return "ドワンゴ"
            R.string.smartnews -> return "SmartNews"
            R.string.increments -> return "Increments"
            R.string.recruit_jobs -> return "リクルートジョブズ"
        }
        return ""
    }
}