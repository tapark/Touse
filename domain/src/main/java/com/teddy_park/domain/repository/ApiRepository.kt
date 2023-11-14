package com.teddy_park.domain.repository

import com.skydoves.sandwich.ApiResponse
import com.teddy_park.domain.model.S3TokenResponse

interface ApiRepository {

    suspend fun getS3Token(

    ): ApiResponse<S3TokenResponse>

}