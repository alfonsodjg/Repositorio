package com.example.repositorio.ui.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns

@SuppressLint("Range")
fun Uri.getFileName(context: Context): String {
    var result: String? = null
    if (scheme == "content") {
        val cursor = context.contentResolver.query(this, null, null, null, null)
        try {
            cursor?.let {
                if (it.moveToFirst()) {
                    result = it.getString(it.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                }
            }
        } finally {
            cursor?.close()
        }
    }
    if (result == null) {
        result = path
        val cut = result?.lastIndexOf('/')
        if (cut != -1) {
            result = result?.substring(cut!! + 1)
        }
    }
    return result ?: ""
}