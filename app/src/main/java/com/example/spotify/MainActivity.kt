package com.example.spotify

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.spotify.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var config: Config

    val apiservice: TodoApi = RetrofitInstance.api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
//4
        val api = RetrofitInstance.api
        api.getTodos(BuildConfig.VENDORID).enqueue(object : Callback<Config> {
            override fun onResponse(call: Call<Config>, response: Response<Config>) {
                if (response.isSuccessful) {
                    config = response.body()!!
                    makeDynamicUi()
                }
            }

            override fun onFailure(call: Call<Config>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun makeDynamicUi() {
        title = config.vendorName

        binding.textView2.apply {
            text = config.footer.text
            setTextColor(Color.parseColor(config.footer.color))
            if (config.footer.isItalic) {
                binding.textView2.typeface = Typeface.create(typeface, Typeface.ITALIC)
            }
        }
        setupArtistRecyclerview()
    }

          /**populating listview*/
//          binding.listView1.adapter = ArrayAdapter<String>(
//            this, R.layout.simple_list_item_1,config.genres
//          )


        /**populating recyclerview
         */

    fun setupArtistRecyclerview() {

        apiservice.getContent(config.sections[0].url).enqueue(object : Callback<List<Artist>> {
            override fun onResponse(call: Call<List<Artist>>, response1: Response<List<Artist>>) {
                if (response1.isSuccessful) {
                    binding.recyclerView.apply {
                        adapter = ContentAdapter(response1.body()!!)
                        /**grid view*/
                        binding.recyclerView.setLayoutManager(GridLayoutManager(this@MainActivity, 2))
                        /**recyclerview*/
//                        layoutManager = LinearLayoutManager(
//                            this@MainActivity, LinearLayoutManager
//                                .HORIZONTAL, false
//                        )
                    }
                    Log.d("Response", response1.toString())
                }
            }

            override fun onFailure(call: Call<List<Artist>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}