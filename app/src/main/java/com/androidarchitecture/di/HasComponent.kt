package com.androidarchitecture.di

/**
 * Interface representing a contract for clients that contains a component for dependency injection.
 */
interface HasComponent<C : BaseComponent> {
    fun getComponent(): C
}
