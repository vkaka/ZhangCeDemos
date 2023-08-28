package com.example.zhangcedemos.shopping_cart

/**
 * author : zhangce
 * date: on 2023/8/26
 **/
data class ShoppingCartBean(
    val title: String,
    val content: List<ShoppingProductBean>
)

data class ShoppingProductBean(
    val name: String,
    val isSelect: Boolean = false
)