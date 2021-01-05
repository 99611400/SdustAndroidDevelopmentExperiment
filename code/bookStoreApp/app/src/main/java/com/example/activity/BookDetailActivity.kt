package com.example.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.example.entity.Book
import com.example.entity.ResultMessage
import com.example.test.R
import com.example.util.GetConfig
import com.example.util.MyStringRequest
import com.example.util.VolleySingleton
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_book_detail.*
import org.json.JSONObject

class BookDetailActivity : AppCompatActivity() {
    companion object{
        fun actionStart(context: Context, book: Book){
            val bookDetailIntent: Intent = Intent(context,BookDetailActivity::class.java)
            bookDetailIntent.putExtra("book",book)
            context.startActivity(bookDetailIntent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val jsonObject: JSONObject = GetConfig(assets).getJsonConfig()
        val baseUrl = jsonObject["baseUrl"] as String

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
        val book :Book = intent.getParcelableExtra("book")!!
        book_detail_name.text = book.bookName
        book_detail_detail.text = book.bookDetail
        book_detail_price.text = book.bookPrice
        book_detail_addToShoppingCartBtn.setOnClickListener {
            val prefs =  getSharedPreferences("currentUser",Context.MODE_PRIVATE)
            val userId:Int = prefs.getInt("userId",0)

            val stringRequest = MyStringRequest(
                Request.Method.GET,
                "$baseUrl/restApi/shoppingCart/add?userId=$userId&bookId=${book.bookId}",
                Response.Listener {
                    val tempResultMessage: ResultMessage = Gson().fromJson(it, ResultMessage::class.java)
                    if (tempResultMessage.code == 200){
                        Toast.makeText(this,"加入购物车成功",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"查询失败", Toast.LENGTH_SHORT).show()
                    }
                },
                Response.ErrorListener {
                    Log.e("aa",it.toString())
                }
            )
            VolleySingleton.getInstance(getApplication()).requestQueue.add(stringRequest)
        }

    }
}