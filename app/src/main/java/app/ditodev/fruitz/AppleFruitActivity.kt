package app.ditodev.fruitz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AppleFruitActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var btnBackHome : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_apple_fruit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBackHome = findViewById(R.id.btnHome)
        btnBackHome.setOnClickListener(this)
        Utils.changeStatusBarColor(window,"#0070ff")
    }

    override fun onClick(p0: View?) {
        if (p0?.id != null){
            val backToHome = Intent(this@AppleFruitActivity , MainActivity::class.java)
            startActivity(backToHome)
        }
    }
}