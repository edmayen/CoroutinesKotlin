package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // First Coroutine
        /*
        GlobalScope.launch{
           delay((3000L))
           Log.d(TAG, "Coroutine says hello from thread ${Thread.currentThread().name}")
        }
        Log.d(TAG, "Hello from thread ${Thread.currentThread().name}")
         */


        //Suspend Functions
        /*
        GlobalScope.launch {
            val networkCallAnswer = doNetworkCall()
            val networkCallAnswer2 = doNetworkCall2()
            Log.d(TAG, networkCallAnswer)
            Log.d(TAG, networkCallAnswer2)
        }
         */

        //Coroutines Context
        /*
        GlobalScope.launch(Dispatchers.IO){
            Log.d(TAG, "Starting coroutine in thread ${Thread.currentThread().name}")
            val answer = doNetworkCall()
            withContext(Dispatchers.Main){
                Log.d(TAG, "Setting text in thread ${Thread.currentThread().name}")
                tvDummy.text = answer
            }
        }
         */

        Log.d(TAG, "Before runBlocking")
        runBlocking {
            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(TAG, "Finished IO Coroutine 1")
            }
            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(TAG, "Finished IO Coroutine 2")
            }
            Log.d(TAG, "Start of runBlocking")
            delay(100L)
            Log.d(TAG, "End of runBlocking")
        }
        Log.d(TAG, "After runBlocking")
    }

    //Coroutines Context
    /*
    suspend fun doNetworkCall(): String{
        delay(30000L)
        return "This is the answer"
    }
     */

    //Suspend Functions
    /*
    suspend fun doNetworkCall(): String{
        delay(30000L)
        return "This is the answer"
    }

    suspend fun doNetworkCall2(): String{
        delay(30000L)
        return "This is the answer"
    }
     */
}