package com.delarosa.pushnotificationmvvm.viewModel

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.delarosa.pushnotificationmvvm.R
import com.delarosa.pushnotificationmvvm.model.NotificationDto

class NotificationAdapter(private val notificationList: ArrayList<NotificationDto>) :
    RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notification: NotificationDto = notificationList[position]
        holder.textViewTime.text = notification.time
        holder.textViewDescription.text = notification.description
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.message_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTime = itemView.findViewById(R.id.time_notification) as TextView
        val textViewDescription = itemView.findViewById(R.id.description_notification) as TextView
    }

}