package com.turbosoft.remindme.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.turbosoft.remindme.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //This is test for github Public key
    }
}