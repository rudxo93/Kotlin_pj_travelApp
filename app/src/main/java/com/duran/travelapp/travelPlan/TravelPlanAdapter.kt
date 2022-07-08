package com.duran.travelapp.travelPlan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duran.travelapp.R
import com.duran.travelapp.dto.AddPlanDto

class TravelPlanAdapter(val context: TravelPlanFragment): RecyclerView.Adapter<TravelPlanAdapter.TravelPlanViewHolder>() {

    private var list = mutableListOf<AddPlanDto>()

    inner class TravelPlanViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.tv_item_plan_title)
        var sDate = itemView.findViewById<TextView>(R.id.tv_item_plan_start_date)
        var eDate = itemView.findViewById<TextView>(R.id.tv_item_plan_end_date)

        fun onBind(data: AddPlanDto){
            title.text = data.title
            sDate.text = data.sdate
            eDate.text = data.edate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelPlanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_travel_plan, parent, false)
        return TravelPlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: TravelPlanViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun update(newList: MutableList<AddPlanDto>) {
        this.list = newList
        notifyDataSetChanged()
    }

}