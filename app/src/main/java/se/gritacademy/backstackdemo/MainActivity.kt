package se.gritacademy.backstackdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    lateinit var fm :FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm = supportFragmentManager

        findViewById<Button>(R.id.button).setOnClickListener{ v ->
            fm
                .beginTransaction()
                .replace(R.id.frameLayout, BlankFragment() )  //röd
                .addToBackStack("frag1")
                .commit()
             if(fm.backStackEntryCount > 0) {
                 var stackAmount: Int = fm.backStackEntryCount
                 var stackId = fm.getBackStackEntryAt(stackAmount - 1)

                 Log.d("Alrik", "nuvarande backstacks indexes: $stackAmount")
                 Log.d("Alrik", "nuvarande backstacks top är: ${stackId.toString()}")
             }
         }

        findViewById<Button>(R.id.button2).setOnClickListener{ v ->
            fm
                .beginTransaction()
                .replace(R.id.frameLayout, BlankFragment2() ) // cyan
                .addToBackStack("frag2")
                .commit()
        }

        findViewById<Button>(R.id.button3).setOnClickListener{ v ->
            fm
                .beginTransaction()
                .replace(R.id.frameLayout, BlankFragment3() ) // cyan
                .addToBackStack("frag3")
                .commit()
        }
        findViewById<Button>(R.id.deleteBTN).setOnClickListener{ v ->
            //fm.popBackStack() //överst senaste
           // fm.popBackStack("frag2",0) // om du ligger i "frag2"
            val intent = Intent(this, this@MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            this.startActivity(intent)
        }
        findViewById<Button>(R.id.buttonActivity).setOnClickListener{ v ->
            //fm.popBackStack() //överst senaste
           // fm.popBackStack("frag2",0) // om du ligger i "frag2"
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        }




    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}