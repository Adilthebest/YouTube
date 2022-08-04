package com.example.sixthmsecondhmyoutubeapp.youtube.model

import androidx.room.Entity

data class Item(

    val contentDetails: ContentDetails,
    val etag: String,
    val id: String,
    val kind: String,
    val snippet: Snippet
)