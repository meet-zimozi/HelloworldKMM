package com.example.coroutines.helloworldkmm.shared

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class ApiConfig() {

    private val httpClient= HttpClient()

    suspend fun fetchData():String{
        return httpClient.get<String> {
            url("$baseUrl/trades/latest")
            headers.set("X-CoinAPI-Key","8D335D5D-B8E6-457B-AB28-E873763227B6")
        }
    }

    companion object {
        private const val baseUrl="https://rest.coinapi.io/v1"
    }
}