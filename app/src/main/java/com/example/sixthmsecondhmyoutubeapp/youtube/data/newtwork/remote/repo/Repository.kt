package com.example.sixthmsecondhmyoutubeapp.youtube.data.newtwork.remote.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.sixthmsecondhmyoutubeapp.youtube.App
import com.example.sixthmsecondhmyoutubeapp.youtube.data.domain.Resource
import com.example.sixthmsecondhmyoutubeapp.youtube.data.newtwork.RetrofitClient
import com.example.sixthmsecondhmyoutubeapp.youtube.model.PlayList
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import org.json.JSONObject

class Repository {

    private val apiService = RetrofitClient.create()

    fun getPlaylist(): LiveData<Resource<PlayList?>> = liveData(Dispatchers.IO){
        emit(Resource.loading())

        val result = apiService.getPlaylist()
        if (result.isSuccessful){
            emit(Resource.success(result.body()))
        } else {
            val jObjError = result.errorBody()?.string()
            val gson = Gson()
            val data = gson.fromJson(jObjError,ErrorResponse::class.java)
            emit(Resource.error(data.error?.message.toString()))
        }
    }

    fun getLocalPlaylist(): LiveData<Resource<PlayList?>> = liveData(Dispatchers.IO){
        emit(Resource.loading())
        val result = App.db.dao().getPlaylist()
            emit(Resource.success(result))
        }

    fun setPlayList(playList: PlayList):LiveData<Resource<Boolean>> = liveData(Dispatchers.IO){
        App.db.dao().insert(playList)
        emit(Resource.success(true))
    }
}