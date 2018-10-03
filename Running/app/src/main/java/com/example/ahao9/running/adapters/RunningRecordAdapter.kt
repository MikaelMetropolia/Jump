package com.example.ahao9.running.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.ahao9.running.R
import com.example.ahao9.running.model.RunningRecordBean
import kotlinx.android.synthetic.main.route_record_list_item.view.*

/**
 * @ Author     ：Hao Zhang.
 * @ Date       ：Created in 21:13 2018/10/3
 * @ Description：Build for Metropolia project
 */
class RunningRecordAdapter(val list: List<RunningRecordBean>, val context: Context)
    : RecyclerView.Adapter<RunningRecordAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = View.inflate(context, R.layout.route_record_list_item, null)
        return MyHolder(view)
    }

    override fun onBindViewHolder(myHolder: MyHolder, position: Int) {
        myHolder.setDataAndRefreshUI(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {

            itemView.setOnClickListener {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener!!.onItemClick(it, position)
                }
            }
        }

        fun setDataAndRefreshUI(dataBean: RunningRecordBean) {

            itemView.ivRouteType
                    .setImageResource(if (dataBean.type == 1) R.drawable.tracetype_run
                    else R.drawable.tracetype_bike)

            itemView.tvRouteDistance.text = dataBean.distance
            itemView.tvRouteTimeLast.text = dataBean.timeLast
        }
    }

    interface MyItemClickListener {
        fun onItemClick(view: View, postion: Int)
    }

    private var mOnItemClickListener: MyItemClickListener? = null

    fun setOnItemClickListener(listener: MyItemClickListener) {
        this.mOnItemClickListener = listener
    }

}