package com.example.repositorio.domain.core.utils

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.ParcelFileDescriptor
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import org.koin.java.KoinJavaComponent.get
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

//No funciono por el momento
class DecodeFilePdf {
    @RequiresApi(Build.VERSION_CODES.Q)
    fun createFile(
        fileName: String,
        context: Context = get(Context::class.java),
        inputStream: ByteArray
    ): Uri? {
        val contentResolver = context.contentResolver
        var outputStream: OutputStream? = null
        val values = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
            put(MediaStore.MediaColumns.MIME_TYPE, "application/pdf")
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
        }
        val uri = contentResolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, values)
        try {
            var pfd: ParcelFileDescriptor? = null
            try {
                pfd = uri?.let { contentResolver.openFileDescriptor(it, "w") }!!
                outputStream = FileOutputStream(pfd.fileDescriptor)
                outputStream.write(inputStream)
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            } finally {
                outputStream?.close()
                pfd?.close()
            }
            values.clear()
            values.put(MediaStore.Video.Media.IS_PENDING, 0)
            uri?.let {
                context.contentResolver.update(it, values, null, null)
                outputStream = context.contentResolver.openOutputStream(uri)
            }
            return uri
        } catch (e: IOException) {
            uri?.let {
                context.contentResolver.delete(it, null, null)
            }
        } finally {
            outputStream?.close()
        }
        return null
    }
}