package com.example.fragmentkotlinintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FirstFragment.FirstListener,
    SecondFragment.SecondListener {
    var firstFragment: FirstFragment? = null
    var secondFragment: SecondFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    override fun onFirstSend(user: User?) {
        secondFragment!!.updateSecondText(user.toString())
    }

    override fun onSecondSend(user: User?) {
        firstFragment!!.updateFirstText(user.toString())
    }

    fun initViews() {
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameFirst, firstFragment!!)
            .replace(R.id.frameSecond, secondFragment!!)
            .commit()
    }
}