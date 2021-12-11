package com.example.medapp.utils


import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content
}

class EventObserver<T : Any?>(
    private val onUnhandledChange: (T) -> Unit
) : Observer<Event<T>?> {

    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let {
            onUnhandledChange(it)
        }
    }
}


@MainThread
inline fun <T : Any> LiveData<Event<T>>.observeEvent(
    owner: LifecycleOwner,
    crossinline onChanged: (T) -> Unit
): Observer<Event<T>?> {
    val wrappedObserver = EventObserver<T> { t -> onChanged.invoke(t) }
    observe(owner, wrappedObserver)
    return wrappedObserver
}
