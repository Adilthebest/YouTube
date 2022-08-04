package com.example.sixthmsecondhmyoutubeapp.youtube

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sixthmsecondhmyoutubeapp.youtube.local.room.AppDatabase

class App : Application() {


    companion object {

        lateinit var db: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        db =
            Room.databaseBuilder(this, AppDatabase::class.java, "database")
                .build()
    }
}