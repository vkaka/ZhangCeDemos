package com.example.zhangcedemos.shopping_cart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zhangcedemos.R

/**
 * author : zhangce
 * date: on 2023/8/26
 **/
class ShoppingCartAdapter(val mContext: Context) :
    RecyclerView.Adapter<ShoppingCartAdapter.ShoppingViewHolder>() {

    private val mData = mutableListOf<ShoppingCartBean>()

    class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTv = itemView.findViewById<TextView>(R.id.shopping_user_name_tv)
        val contentLL = itemView.findViewById<LinearLayout>(R.id.shopping_product_list_ll)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shopping_cart, null)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val bean = mData[position]
        holder.apply {
            titleTv.text = bean.title
            initData(contentLL, bean.content)
        }
    }

    fun initData(layout: LinearLayout, list: List<ShoppingProductBean>) {
        layout.removeAllViews()
        for (bean in list) {
            val item =
                LayoutInflater.from(mContext).inflate(R.layout.layout_shopping_cart_item, null)
            val name = item.findViewById<TextView>(R.id.layout_shopping_title_tv)
            name.text = bean.name
            layout.addView(item)
        }
    }

    fun setData(data: List<ShoppingCartBean>) {
        this.mData.addAll(data)
        notifyDataSetChanged()
    }
}