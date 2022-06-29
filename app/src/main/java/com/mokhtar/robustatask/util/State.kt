package com.mokhtar.robustatask.util

import java.io.IOException

/**
 * State Management for UI & Data.
 */
sealed class State<out T> {

    data class Success<T>(val data: T) : State<T>()

    data class Error(val exception: Throwable) : State<Nothing>() {

        val isNetworkError: Boolean get() = exception is IOException
    }

    object Empty : State<Nothing>()

    object Loading : State<Nothing>()

    companion object {

        /**
         * Return [Success] with [data] to emit.
         */
        fun <T> success(data: T) = Success(data)

        /**
         * Return [Error] with [exception] to emit.
         */
        fun error(exception: Throwable) = Error(exception)

        /**
         * Return [Empty].
         */
        fun empty() = Empty

        /**
         * Return [Loading].
         */
        fun loading() = Loading

        /**
         * Return [Empty] if [list] is empty, otherwise return [Success].
         */
        fun <T> successOrEmpty(list: List<T>): State<List<T>> {
            return if (list.isEmpty()) Empty else Success(list)
        }
    }
}