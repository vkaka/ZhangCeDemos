package com.example.zhangcedemos.shopping_cart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zhangcedemos.R

/**
 * author : zhangce
 * date: on 2023/8/26
 **/
class ShoppingCartActivity : AppCompatActivity() {

    private lateinit var contentRV: RecyclerView
    private var mAdapter: ShoppingCartAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)
        initView()
        initListener()
        initData()
    }

    private fun initView() {
        contentRV = findViewById(R.id.shopping_cart_rv)
    }

    private fun initListener() {

    }

    private fun initData() {
        val shoppingList = mutableListOf<ShoppingCartBean>()
        for (i in 1..5) {
            val productList = mutableListOf<ShoppingProductBean>()
            for (j in 1..3) {
                val productBean = ShoppingProductBean("商品名字$i")
                productList.add(productBean)
            }
            val userBean = ShoppingCartBean("公司名称$i", productList)
            shoppingList.add(userBean)
        }


        contentRV.apply {
            layoutManager =
                LinearLayoutManager(this@ShoppingCartActivity, LinearLayoutManager.VERTICAL, false)
            mAdapter = ShoppingCartAdapter(this@ShoppingCartActivity)
            mAdapter?.setData(shoppingList)
            adapter = mAdapter
        }
    }
}