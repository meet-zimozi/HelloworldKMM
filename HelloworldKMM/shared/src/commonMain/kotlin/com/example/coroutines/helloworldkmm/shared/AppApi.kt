package com.example.coroutines.helloworldkmm.shared

class AppApi {
    suspend fun fetchData(): String {
        return "Data From API: " +ApiConfig().fetchData()
    }
}