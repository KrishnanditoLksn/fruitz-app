package app.ditodev.fruitz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var nextBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        nextBtn = findViewById(R.id.button)
        nextBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0?.id != null){
            val intents = Intent(this@MainActivity , NextFruit::class.java)
            startActivity(intents)
        }
    }

}