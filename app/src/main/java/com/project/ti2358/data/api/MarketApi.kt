package com.project.ti2358.data.api

import com.project.ti2358.data.model.dto.Candles
import com.project.ti2358.data.model.dto.Interval
import com.project.ti2358.data.model.dto.Stocks
import com.project.ti2358.data.model.response.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarketApi {
    @GET("market/stocks")
    suspend fun stocks(): Response<Stocks>

    @GET("market/search/by-ticker")
    suspend fun searchByTicker(@Query("ticker") ticker: String): Response<Stocks>

    @GET("market/candles")
    suspend fun candles(
        @Query("figi") figi: String,
        @Query("interval") interval: String,
        @Query("from") from: String,            // 2019-08-19T18:38:33.131642+03:00
        @Query("to") to: String,                // 2019-08-19T18:38:33.131642+03:00
    ): Response<Candles>
}