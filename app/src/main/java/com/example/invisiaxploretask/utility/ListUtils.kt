package com.example.invisiaxploretask.utility

import android.view.View
import android.widget.TextView

/**
 * Created by Tejas Dani on 31-Aug-2023
 * Handle Empty adapter and show message if list is empty
 *
 * */

fun <T> List<T>?.handleAdapterIfEmpty(textView: TextView, recyclerView: View, message: String = "", show: (list :List<T>) -> Unit): List<T> {
    if (this?.isNotEmpty() == true) {
        textView.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
        show(this)
    } else {
        if (message.isNotBlank()) {
            textView.text = message
        }
        textView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE

    }
    return this ?: listOf()
}