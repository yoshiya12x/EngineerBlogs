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
        }
        return ""
    }

    fun getNextTitle(blogTitle: Int): String {
        when (blogTitle) {
            R.string.recruit_mp -> return "リクルートマーケティングパートナーズ"
            R.string.eureka -> return "エウレカ"
            R.string.line -> return "LINE"
        }
        return ""
    }
}