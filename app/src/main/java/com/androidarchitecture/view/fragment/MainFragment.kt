package com.androidarchitecture.view.fragment

import android.arch.lifecycle.Observer
import android.support.v4.app.Fragment
import android.os.Bundle
import com.androidarchitecture.R
import com.androidarchitecture.core.BaseFragment
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.EditText
import com.androidarchitecture.entity.Task
import com.androidarchitecture.view.adapter.TaskAdapter
import com.androidarchitecture.view.model.TaskViewModel


/**
 * Created by binary on 5/20/17.
 */
class MainFragment : BaseFragment() {

    private lateinit var taskViewModel: TaskViewModel
    private lateinit var taskAdapter: TaskAdapter
    private val taskList = mutableListOf<Task>()

    companion object {
        fun newInstance(): Fragment = MainFragment()
    }

    //region BaseFragment
    override fun getContentViewID(): Int = R.layout.fragment_main

    override fun initView(savedInstanceState: Bundle?) {
        view?.findViewById(R.id.fab)?.setOnClickListener { showAddDialog() }
        initRecycleView()
        taskViewModel = ViewModelProviders.of(this@MainFragment).get(TaskViewModel::class.java)
        taskViewModel.taskDataSource = getAppComponent()?.taskDataSource()!!
        taskViewModel.getTasks()?.observe(this@MainFragment, Observer {
            taskList.clear()
            it?.let {
                taskList.addAll(it)
                taskAdapter.notifyDataSetChanged()
            }
        })
    }
    //endregion

    //region Utility API
    private fun initRecycleView() {
        val taskRecycleView = view?.findViewById(R.id.task_list) as RecyclerView
        taskRecycleView.layoutManager = LinearLayoutManager(context)
        taskAdapter = TaskAdapter(taskList)
        taskRecycleView.adapter = taskAdapter
    }

    private fun showAddDialog() {
        AlertDialog.Builder(this@MainFragment.context).apply {
            setTitle(getString(R.string.add_to_todo_list))
            val input = EditText(this@MainFragment.context)
            setView(input)
            setPositiveButton("OK", { d, _ -> taskViewModel.addTask(input.text.toString()); d.cancel() })
            setNegativeButton("Cancel", { d, _ -> d.cancel() })
            show()
        }
    }
    //endregion
}