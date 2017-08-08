package com.androidarchitecture.core.executor

import android.support.annotation.NonNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Created by binary on 5/19/17.
 */
@Singleton
class JobExecutor @Inject constructor() : ThreadExecutor {

    private val mThreadPoolExecutor: ThreadPoolExecutor

    init {
        val workQueue = LinkedBlockingQueue<Runnable>()
        val threadFactory = com.androidarchitecture.core.executor.ThreadFactory(THREAD_NAME_)
        mThreadPoolExecutor = ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, workQueue, threadFactory)
    }

    override fun execute(runnable: Runnable) {
        mThreadPoolExecutor.execute(runnable)
    }

    companion object {

        private val INITIAL_POOL_SIZE = 3
        private val MAX_POOL_SIZE = 5

        // Sets the amount of time an idle thread waits before terminating
        private val KEEP_ALIVE_TIME = 10L

        // Sets the Time Unit to seconds
        private val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS

        private val THREAD_NAME_ = "android_"
    }
}