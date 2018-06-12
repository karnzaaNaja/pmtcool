package com.example.msi.cool

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    private val handler: Handler = Handler()
    private lateinit var runner: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        runner = Runnable {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    public override fun onResume() {
        super.onResume()
        handler.postDelayed(runner, 3000)
    }

    public override fun onStop() {
        super.onStop()
        handler.removeCallbacks(runner)
    }
}
