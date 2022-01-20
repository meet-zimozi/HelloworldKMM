package com.example.coroutines.helloworldkmm.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutines.helloworldkmm.shared.Greeting
import android.widget.TextView
import com.example.coroutines.helloworldkmm.shared.AppApi
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun greet(): String {
    return Greeting().greeting()
}

suspend fun fetchData(): String {
    return AppApi().fetchData()
}

class MainActivity : AppCompatActivity(), CoroutineScope {

    private val job = Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tv: TextView = findViewById(R.id.text_view)
        launch(Dispatchers.Main) {
            try {

                val result = withContext(Dispatchers.Main) {
                    fetchData()
                }
                tv.text =result
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


    }

    override val coroutineContext: CoroutineContext
        get() = job

}
