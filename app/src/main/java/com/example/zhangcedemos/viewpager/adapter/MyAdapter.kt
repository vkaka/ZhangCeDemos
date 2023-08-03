package com.example.zhangcedemos.viewpager.adapter

import android.content.Context
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.example.zhangcedemos.R

/**
 * author : zhangce
 * date: on 2023/8/3
 **/
class MyAdapter(val mContext: Context) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val data = ArrayList<Int>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view = itemView.findViewById<View>(R.id.item_vp_v)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_viewpager2, null)
        val params = LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT)
        view.layoutParams = params
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        when (position) {
            0 -> {
                holder.view.setBackgroundColor(mContext.resources!!.getColor(R.color.red))
            }
            1 -> {
                holder.view.setBackgroundColor(mContext.resources!!.getColor(R.color.green))
            }
            2 -> {
                holder.view.setBackgroundColor(mContext.resources!!.getColor(R.color.black))
            }
            3 -> {
                holder.view.setBackgroundColor(mContext.resources!!.getColor(R.color.blue))
            }
        }
    }

    fun setData(colors: List<Int>) {
        data.clear()
        if (colors.isNotEmpty()) {
            data.addAll(colors)
        }
        notifyDataSetChanged()
    }
}