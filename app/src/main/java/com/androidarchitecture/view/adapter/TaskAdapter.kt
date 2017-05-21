package com.androidarchitecture.view.adapter


import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.androidarchitecture.R
import com.androidarchitecture.entity.Task

/**
 * Created by binary on 5/22/17.
 */
class TaskAdapter(val taskList: List<Task>): Adapter<TaskAdapter.Holder>() {

    //region Adapter
    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.taskView?.text = taskList[position].task
    }

    override fun getItemCount(): Int = taskList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent?.context).inflate(R.layout.layout_task, parent, false))
    }
    //endregion

    inner class Holder(view: View): RecyclerView.ViewHolder(view) {
        val taskView: TextView = view.findViewById(R.id.task) as TextView
    }
}