package com.example.sixthmsecondhmyoutubeapp.youtube.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.sixthmsecondhmyoutubeapp.youtube.base.BaseViewModel
import com.example.sixthmsecondhmyoutubeapp.youtube.data.domain.Resource
import com.example.sixthmsecondhmyoutubeapp.youtube.data.newtwork.remote.repo.Repository
import com.example.sixthmsecondhmyoutubeapp.youtube.model.PlayList

class PlaylistViewModel : BaseViewModel() {
    private val repo = Repository()
    private val _playlist= MutableLiveData<PlayList>()

    private val _result = MutableLiveData<Boolean>()
private val _local = MutableLiveData<Boolean>()
val setPlayList = _playlist.switchMap {
    repo.setPlayList(it)
}
val playList =_result.switchMap {
    repo.getPlaylist()
}
    fun getPlayList(){
_result.value = true
    }
    val localPlayList = _local.switchMap {
        repo.getLocalPlaylist()
    }
    fun setPlayList(playList: PlayList){
        _playlist.value = playList
    }
    fun getLocalPlayList(){
        _local.value = true
    }
}