package com.raspberry.djangokt

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var server_url = "http://10.0.0.182:8000"
    lateinit var leftButton: Button
    lateinit var rightButton: Button
    lateinit var goButton: Button
    lateinit var stopButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        leftButton = findViewById(R.id.leftButton)
        rightButton = findViewById(R.id.rightButton)
        goButton = findViewById(R.id.goButton)
        stopButton = findViewById(R.id.stopButton)

        leftButton.setOnClickListener(this)
        rightButton.setOnClickListener(this)
        goButton.setOnClickListener(this)
        stopButton.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.leftButton -> ParseTask().execute("/run/?action=left")
            R.id.rightButton -> ParseTask().execute("/run/?action=right")
            R.id.goButton -> ParseTask().execute("/run/?action=forward")
            R.id.stopButton -> ParseTask().execute("/run/?action=stop")
        }
    }

    private inner class ParseTask : AsyncTask<String?, Void?, Void?>() {
        var urlConnection: HttpURLConnection? = null
        var reader: BufferedReader? = null
        var resultJson = ""
        var data: String? = null
        protected override fun doInBackground(vararg p0: String?): Void? {
            try {
                data = p0[0]
                Log.d("tag", "doInBackground: $data")
                val site_url_json = server_url + data
                Log.d("tag", "doInBackground: $site_url_json")
                val url = URL(site_url_json)
                urlConnection = url.openConnection() as HttpURLConnection
                urlConnection!!.requestMethod = "GET"
                urlConnection!!.connect()
                val inputStream = urlConnection!!.inputStream
                val buffer = StringBuffer()
                reader = BufferedReader(InputStreamReader(inputStream))
                var line: String?
                while (reader!!.readLine().also { line = it } != null) {
                    buffer.append(line)
                }
                resultJson = buffer.toString()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }
    }
}