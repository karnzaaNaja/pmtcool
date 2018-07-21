package com.example.msi.cool

import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.example.msi.cool.ui.contact.ContactFragment
import com.example.msi.cool.ui.customer.CustomerFragment
import com.example.msi.cool.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.item_dialog_exit.*

class HomeActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.containerFragment, HomeFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                supportFragmentManager.beginTransaction().replace(R.id.containerFragment, CustomerFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                supportFragmentManager.beginTransaction().replace(R.id.containerFragment, ContactFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, HomeFragment())
            .commit()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onBackPressed() {
        Dialog(this, R.style.DialogTheme).apply {
            setContentView(R.layout.item_dialog_exit)
            window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            btnYes.setOnClickListener { finish() }
            btnNo.setOnClickListener { hide() }
            show()
        }
    }

    //****

}
