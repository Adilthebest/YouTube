package com.example.sixthmsecondhmyoutubeapp.youtube.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.sixthmsecondhmyoutubeapp.youtube.model.PlayList

@Dao
interface Dao {

    @Insert(onConflict = REPLACE)
    fun insert(playlist: PlayList)

    @Insert
    fun insertAll(playlist: List<PlayList>)

    @Query("SELECT * FROM playlist ")
    fun getPlaylist(): PlayList
}