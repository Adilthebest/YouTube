package com.example.sixthmsecondhmyoutubeapp.youtube.data.newtwork.remote.repo

data class ErrorResponse (
    val error:ErrorBody? = null
    )

    data class ErrorBody(
        val code:Int?=null,
        val message: String? = null
    )

