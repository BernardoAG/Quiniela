package com.example.bernardoaltamirano.quiniela.help

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.bernardoaltamirano.quiniela.R
import kotlinx.android.synthetic.main.activity_help.*
import timber.log.Timber


class HelpActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        web_view.loadUrl("https://www.fifa.com/worldcup/matches/")
        val webSettings = web_view.settings
        webSettings.setJavaScriptEnabled(true)

        Timber.d(web_view.url)
    }
}