package app.ditodev.fruitz

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var nextBtn: Button
    private lateinit var btnFruitsList: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        nextBtn = findViewById(R.id.button)
        nextBtn.setOnClickListener(this)

        btnFruitsList = findViewById(R.id.btnLists)
        btnFruitsList.setOnClickListener(this)
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