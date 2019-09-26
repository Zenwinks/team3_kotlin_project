package epsi.b3.team3_kotlin_project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cocktails(view: View) {
        startActivity(Intent(this, CocktailsActivity::class.java))
    }

    fun ingredients(view: View) {
        startActivity(Intent(this, IngredientsActivity::class.java))
    }

    fun random(view: View) {
        startActivity(Intent(this, RandomActivity::class.java))
    }

}
