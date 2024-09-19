package app.ditodev.fruitz

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import app.ditodev.fruitz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.button.setOnClickListener(this)
        mainBinding.btnLists.setOnClickListener(this)
        Utils.changeStatusBarColor(window, "#3498db")


        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.rgb(255, 99, 71)))
        supportActionBar!!.title = "Home Page"
    }

    override fun onClick(p0: View?) {
        if (p0?.id != null) {
            when (p0.id) {
                R.id.button -> {
                    val intents = Intent(this@MainActivity, NextFruit::class.java)
                    startActivity(intents)
                }

                R.id.btnLists -> {
                    val btnLists = Intent(this@MainActivity, FruitsRecyclerview::class.java)
                    startActivity(btnLists)
                }
            }
        }
    }
}