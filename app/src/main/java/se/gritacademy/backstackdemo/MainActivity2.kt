package se.gritacademy.backstackdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        findViewById<Button>(R.id.back).setOnClickListener { v ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}