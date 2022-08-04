package com.example.sixthmsecondhmyoutubeapp.youtube.data.newtwork

import com.example.sixthmsecondhmyoutubeapp.BuildConfig
import com.example.sixthmsecondhmyoutubeapp.youtube.data.newtwork.remote.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    companion object {
        fun create(): ApiService {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okkHttpClient = OkHttpClient.Builder().writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS).connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okkHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit.create(ApiService::class.java)
        }
    }
}