package com.teddy_park.data.datasource

import com.skydoves.sandwich.ApiResponse
import com.teddy_park.data.service.ApiService
import com.teddy_park.domain.model.S3TokenResponse
import retrofit2.http.GET
import javax.inject.Inject

class ApiDataSource @Inject constructor(
    private val apiService: ApiService
) {


    suspend fun getS3Token(

    ): ApiResponse<S3TokenResponse> {
        return apiService.getS3Token()
    }


}