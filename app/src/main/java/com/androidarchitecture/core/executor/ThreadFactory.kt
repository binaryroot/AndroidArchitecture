package com.androidarchitecture.core.executor

import java.util.concurrent.atomic.AtomicInteger

/**
 * Created by binary on 8/7/17.
 */
class ThreadFactory
/**
 * Creates a new ThreadFactory where threads are created with a name prefix
 * of `prefix`.

 * @param prefix Thread name prefix. Never use a value of "pool" as in that
 * *      case you might as well have used
 * *      [java.util.concurrent.Executors.defaultThreadFactory].
 */
(prefix: String) : java.util.concurrent.ThreadFactory {
    private val group: ThreadGroup
    private val threadNumber = AtomicInteger(1)
    private val namePrefix: String

    init {
        val s = System.getSecurityManager()
        group = if (s != null)
            s.threadGroup
        else
            Thread.currentThread().threadGroup
        namePrefix = prefix + "-" +poolNumber.getAndIncrement()+ "-thread-"
    }

    override fun newThread(r: Runnable): Thread {
        val t = Thread(group, r,
                namePrefix + threadNumber.getAndIncrement(),
                0)
        if (t.isDaemon) {
            t.isDaemon = false
        }
        if (t.priority != Thread.NORM_PRIORITY) {
            t.priority = Thread.NORM_PRIORITY
        }
        return t
    }

    companion object {

        // Note:  The source code for this class was based entirely on
        // Executors.DefaultThreadFactory class from the JDK8 source.
        // The only change made is the ability to configure the thread
        // name prefix.

        private val poolNumber = AtomicInteger(1)
    }
}