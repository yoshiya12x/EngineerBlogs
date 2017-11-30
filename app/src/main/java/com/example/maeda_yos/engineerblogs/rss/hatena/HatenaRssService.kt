package com.example.maeda_yos.engineerblogs.rss.hatena

import android.database.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by maeda-yos on 2017/11/12.
 */

interface HatenaRssService {
    @GET("{userId}/favorite.rss")
    fun favorite(@Path("userId") userId: String, @Query("of") startIndex: Int): Observable<HatenaRssXml>
}