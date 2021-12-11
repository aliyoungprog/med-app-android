package com.example.medapp.data.datasource

import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.domain.entity.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MedServiceApiDataSource {

    @GET("/users")
    suspend fun getAllUsers(): Response<List<User>>

    @GET("/medcenters")
    suspend fun getAllMedCenters(): Response<List<MedCenter>>

    @GET("/medcenters/best")
    suspend fun getBestMedCenters(): Response<List<MedCenter>>
}

class RetrofitBuilder {
    private val BASE_URL = "http://10.0.2.2:8080/"

    fun create(): MedServiceApiDataSource {
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MedServiceApiDataSource::class.java)
    }
}
