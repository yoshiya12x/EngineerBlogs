package com.example.maeda_yos.engineerblogs.util

/**
 * Created by maeda-yos on 2017/11/26.
 */

class RmpUtil{

    fun getImgUrl(description: String): String? {
        val regex = """.+src="(https.+)" class.+""".toRegex()
        val matchResult = regex.matchEntire(description)
        return matchResult?.groupValues!![1]
    }
}