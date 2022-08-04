package com.example.sixthmsecondhmyoutubeapp.youtube.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.sixthmsecondhmyoutubeapp.youtube.model.PlayList
import com.example.sixthmsecondhmyoutubeapp.youtube.ui.playlist.Converter

@Database(entities = [PlayList::class], version = 1)
@TypeConverters(Converter::class)

abstract class AppDatabase :RoomDatabase() {

    abstract fun dao(): Dao
}