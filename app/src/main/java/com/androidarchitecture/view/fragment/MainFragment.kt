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
import com.androidarchitecture.core.BaseInjectFragment
import com.androidarchitecture.di.BaseComponent
import com.androidarchitecture.di.activity.ActivityComponent
import com.androidarchitecture.entity.Task
import com.androidarchitecture.utility.getViewModel
import com.androidarchitecture.view.adapter.TaskAdapter
import com.androidarchitecture.view.model.TaskViewModel


/**
 * Created by binary on 5/20/17.
 */
class MainFragment : BaseInjectFragment<ActivityComponent>() {


    private lateinit var taskAdapter: TaskAdapter
    private lateinit var taskViewModel: TaskViewModel

    private val taskList = mutableListOf<Task>()

    companion object {
        fun newInstance(): Fragment = MainFragment()
    }

    //region BaseInjectFragment
    override fun getContentViewID(): Int = R.layout.fragment_main

    override fun initView(savedInstanceState: Bundle?) {
        view?.findViewById(R.id.fab)?.setOnClickListener { showAddDialog() }
        initRecycleView()

        taskViewModel.getTasks()?.observe(this, Observer {
            taskList.clear()
            it?.let {
                taskList.addAll(it)
                taskAdapter.notifyDataSetChanged()
            }
        })
    }

    override fun inject(component: ActivityComponent) {
        taskViewModel = getViewModel(TaskViewModel::class.java)
        component.inject(taskViewModel)
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