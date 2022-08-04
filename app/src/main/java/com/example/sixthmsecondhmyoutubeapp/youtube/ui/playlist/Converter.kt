package com.example.sixthmsecondhmyoutubeapp.youtube.ui.playlist

import androidx.room.TypeConverter
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Item
import com.example.sixthmsecondhmyoutubeapp.youtube.model.PageInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

object Converter {

    val gson = Gson()

    @TypeConverter
    fun stringToItem(data: String?): List<Item?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Item?>?>() {}.type
        return gson.fromJson<List<Item?>>(data, listType)
    }

    @TypeConverter
    fun itemsToString(myObjects: List<Item?>?): String? {
        return gson.toJson(myObjects)
    }
    @TypeConverter
    fun pageInfoToString(pageInfo: PageInfo):String?{
        return gson.toJson(pageInfo)
    }
    @TypeConverter
    fun stringToPageInfo(data: String?): PageInfo?{
        return  gson.fromJson(data, PageInfo::class.java)
    }

}