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

class OkHttpRequest(client: OkHttpClient){
    private var client = OkHttpClient()

    init {
        this.client = client
    }

    fun GET(url: String, callback: Callback): Call {
        val request = Request.Builder()
                .url(url)
                .build()

        val call = client.newCall(request)
        call.enqueue(callback)
        return call
    }

    companion object {
        val JSON = MediaType.parse("application/json; charset=utf-8")
    }
}

fun JSONArray.toJSONObjectList(): List<JSONObject>{
    var buffer = emptyList<JSONObject>()
    for(i in 0 until this.length()){
        buffer += this.getJSONObject(i)
    }
    return buffer
}

class RandomActivity : AppCompatActivity(){

    var random: List<Drinks> by Delegates.observable(emptyList()) {property, old, new ->  }

    private val client = OkHttpClient()
    private val url = "https://www.thecocktaildb.com/api/json/v1/1/random.php"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.random_layout)

        OkHttpRequest(client).GET(url, object: Callback {
            override fun onReponse(call: Call?, response: Response){
                val responseData = response.body()?.string()
                runOnUiThread {
                    try {
                        val json = JSONArray(responseData)
                        println("Request Successful!")
                        println(json)

                        val random = json.toJSONObjectList().map {
                            Drinks(
                                it.getInt("idDrink")
                            )
                        }
                        println(random)

                        this@RandomActivity.random = random
                    }catch (e: JSONException){
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call?, e: IOException){
                println("Request Failure.")
            }
        })
    }

}