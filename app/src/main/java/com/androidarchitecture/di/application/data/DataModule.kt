package com.androidarchitecture.di.application.data

import com.androidarchitecture.core.executor.ThreadExecutor
import com.androidarchitecture.data.TaskDataSource
import com.androidarchitecture.data.UserDataSource
import com.androidarchitecture.data.repository.TaskRepository
import com.androidarchitecture.data.repository.TaskRepositoryFactory
import com.androidarchitecture.data.repository.UserRepository
import com.androidarchitecture.data.repository.UserRepositoryFactory

@dagger.Module(includes = arrayOf(DataCreatorModule::class))
class DataModule {

    @dagger.Provides
    @javax.inject.Singleton
    fun providerUserDataSource(dataSourceFactory: UserRepositoryFactory, threadExecutor: ThreadExecutor): UserDataSource {
        return UserRepository(dataSourceFactory, threadExecutor)
    }

    @dagger.Provides
    @javax.inject.Singleton
    fun providerTaskDataSource(dataSourceFactory: TaskRepositoryFactory, threadExecutor: ThreadExecutor): TaskDataSource {
        return TaskRepository(dataSourceFactory, threadExecutor)
    }
}