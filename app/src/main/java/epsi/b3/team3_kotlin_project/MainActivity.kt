package epsi.b3.team3_kotlin_project

import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import kotlin.properties.Delegates


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
