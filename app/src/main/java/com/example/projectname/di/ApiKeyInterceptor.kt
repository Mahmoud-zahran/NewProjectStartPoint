package com.example.projectname.di

import okhttp3.Interceptor
import okhttp3.Response
import java.util.Date
import com.example.projectname.utils.md5

class ApiKeyInterceptor(
    private val publicKey: String,
    private val privateKey: String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        // Timestamp (can be current time in milliseconds or any string)
        val ts = Date().time.toString()

        // Generate hash using MD5 (moved to HashUtils.md5)
        val hash = md5("$ts$privateKey$publicKey")

        // Add required query parameters
        val urlWithParams = originalUrl.newBuilder()
            .addQueryParameter("ts", ts)
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("hash", hash)
            .build()

        // Build the new request
        val requestWithParams = originalRequest.newBuilder()
            .header("User-Agent", "ProjectName")
            .url(urlWithParams)
            .build()

        return chain.proceed(requestWithParams)
    }
}
