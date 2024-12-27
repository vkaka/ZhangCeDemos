package com.example.zhangcedemos.select_city

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zhangcedemos.R
//import me.yokeyword.indexablerv.IndexableAdapter.OnItemContentClickListener
//import me.yokeyword.indexablerv.IndexableEntity
//import me.yokeyword.indexablerv.IndexableHeaderAdapter
//import me.yokeyword.indexablerv.IndexableLayout
import java.util.Arrays

/**
 * author : zhangce
 * date: on 2024/7/1
 **/
class SelectCity2Activity : AppCompatActivity() {

//    private lateinit var mAdapter: ContactAdapter
//    private var mBannerHeaderAdapter: BannerHeaderAdapter? = null
//    private val city = arrayOf(
//        "东莞",
//        "深圳",
//        "广州",
//        "温州",
//        "郑州",
//        "金华",
//        "佛山",
//        "上海",
//        "苏州",
//        "杭州",
//        "长沙",
//        "中山"
//    )
//    private lateinit var indexableLayout: IndexableLayout
    private val cybChangeCityGridViewAdapter: CYBChangeCityGridViewAdapter? = null
    private val list: java.util.ArrayList<String>? = null
    private lateinit var pic_contact_back: ImageView
    private var intent: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_city2)

        initview()
        initAdapter()
        onlisten()
    }

    fun initAdapter() {
//        mAdapter = ContactAdapter(this)
//        indexableLayout.setAdapter<UserEntity>(mAdapter)
//        indexableLayout.setOverlayStyle_Center()
//        mAdapter.setDatas(initDatas())
//        //        indexableLayout.setOverlayStyle_MaterialDesign(Color.RED);
//        // 全字母排序。  排序规则设置为：每个字母都会进行比较排序；速度较慢
//        indexableLayout.setCompareMode(IndexableLayout.MODE_FAST)
//
//        //        indexableLayout.addHeaderAdapter(new SimpleHeaderAdapter<>(mAdapter, "☆",null, null));
//
////         构造函数里3个参数,分别对应 (IndexBar的字母索引, IndexTitle, 数据源), 不想显示哪个就传null, 数据源传null时,代表add一个普通的View
////        mMenuHeaderAdapter = new MenuHeaderAdapter("↑", null, initMenuDatas());
////        indexableLayout.addHeaderAdapter(mMenuHeaderAdapter);
//
//        // 这里BannerView只有一个Item, 添加一个长度为1的任意List作为第三个参数
//        val bannerList: MutableList<String> = ArrayList()
//        bannerList.add("")
////        mBannerHeaderAdapter = BannerHeaderAdapter("↑", null, bannerList)
////        indexableLayout.addHeaderAdapter<Any>(mBannerHeaderAdapter)
    }

    fun initview() {
//        intent = intent
//        pic_contact_back = findViewById(R.id.pic_contact_back)
//        indexableLayout = findViewById(R.id.indexableLayout)
//        indexableLayout.setLayoutManager(LinearLayoutManager(this))
    }

    fun onlisten() {
//        pic_contact_back.setOnClickListener(View.OnClickListener { finish() })
//
//        mAdapter.setOnItemContentClickListener(OnItemContentClickListener<UserEntity> { v, originalPosition, currentPosition, entity ->
//            if (originalPosition >= 0) {
//                intent?.putExtra("city", entity.getNick())
//                setResult(RESULT_OK, intent)
//                finish()
//            } else {
////                ToastUtil.showShort(
////                    this@CityPickerActivity,
////                    ("选中Header/Footer:" + entity.getNick()).toString() + "  当前位置:" + currentPosition
////                )
//            }
//        })
    }

    /**
     * 自定义的Banner Header
     */
//    class BannerHeaderAdapter(index: String?, indexTitle: String?, datas: List<*>?) :
//        IndexableHeaderAdapter<Any?>(index, indexTitle, datas) {
//        override fun getItemViewType(): Int {
//            return TYPE
//        }
//
//        override fun onCreateContentViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
//            val view: View = LayoutInflater.from(parent.context)
//                .inflate(R.layout.item_city_header, parent, false)
//            val holder: VH = VH(view)
//            return holder
//        }
//
//        override fun onBindContentViewHolder(holder: RecyclerView.ViewHolder, entity: Any?) {
//            // 数据源为null时, 该方法不用实现
//            val vh = holder as VH
//            list = ArrayList<String>()
//            for (i in city.indices) {
//                list.add(city.get(i))
//            }
//            println("------------city$list")
//            cybChangeCityGridViewAdapter =
//                CYBChangeCityGridViewAdapter(this@CityPickerActivity, list)
//            vh.head_home_change_city_gridview.adapter = cybChangeCityGridViewAdapter
//            vh.head_home_change_city_gridview.onItemClickListener =
//                AdapterView.OnItemClickListener { parent, view, position, id ->
//                    intent.putExtra("city", list.get(position))
//                    println("aaaaaayyyyyyyyy" + list.get(position))
//                    setResult(RESULT_OK, intent)
//                    finish()
//                }
//            vh.item_header_city_dw.setOnClickListener {
//                intent.putExtra("city", vh.item_header_city_dw.text.toString())
//                setResult(RESULT_OK, intent)
//                finish()
//            }
//        }
//
//        private inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            var head_home_change_city_gridview: GridView =
//                itemView.findViewById<View>(R.id.item_header_city_gridview) as QGridView
//            var item_header_city_dw: TextView =
//                itemView.findViewById<TextView>(R.id.item_header_city_dw)
//        }
//
//        companion object {
//            private const val TYPE = 1
//        }
//    }

//    private fun initDatas(): List<UserEntity> {
//        val list: MutableList<UserEntity> = ArrayList<UserEntity>()
//        // 初始化数据
//        val contactStrings: List<String> =
//            Arrays.asList(*resources.getStringArray(R.array.provinces))
//        val mobileStrings: List<String> =
//            Arrays.asList(*resources.getStringArray(R.array.provinces))
//        for (i in contactStrings.indices) {
//            val contactEntity: UserEntity = UserEntity(contactStrings[i], mobileStrings[i])
//            list.add(contactEntity)
//        }
//        return list
//    }
}