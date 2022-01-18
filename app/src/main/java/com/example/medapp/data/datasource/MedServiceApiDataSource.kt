package com.example.medapp.data.datasource

import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.domain.entity.MedDoctor
import com.example.medapp.domain.entity.News
import com.example.medapp.domain.entity.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MedServiceApiDataSource {

    @GET("/users")
    suspend fun getAllUsers(): Response<List<User>>

    @GET("/medcenters")
    suspend fun getAllMedCenters(): Response<List<MedCenter>>

    @GET("/medcenters/best")
    suspend fun getBestMedCenters(): Response<List<MedCenter>>

    @POST("/add_user")
    suspend fun addUser(@Body user: User): Response<User>

    @GET("/users/find_by_phone/{phone_number}")
    suspend fun getUserByPhoneNumber(@Path("phone_number") phoneNumber: String): Response<User>

    @GET("/doctors")
    suspend fun getAllDoctors(): Response<List<MedDoctor>>

    @GET("/doctors/{doctor_id}")
    suspend fun getDoctorById(@Path("doctor_id") doctor_id: Int): Response<MedDoctor>

    @GET("/news")
    suspend fun getAllNews(): Response<List<News>>

}

class RetrofitBuilder {
    private val BASE_URL = "http://10.0.2.2:8080/"

    fun create(): MedServiceApiDataSource {
        val logger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

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
