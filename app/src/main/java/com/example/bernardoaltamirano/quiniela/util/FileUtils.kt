package com.example.bernardoaltamirano.quiniela.util

import android.net.Uri
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileFilter

/**
 * Created by icaboalo on 02/03/18.
 */
object FileUtils {

    var lastFileGeneratedPath: String? = null

    fun getOutputMediaFileUri(barcode: String, type: String): Uri {
        return Uri.fromFile(getOutputMediaFile(barcode, type))
    }

    private fun getOutputMediaFile(barcode: String, type: String): File? {

        val mediaStorageDir = File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "RappiScan")
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null
            }
        }

        // Create a media file name
        val mediaFile: File
        mediaFile = File(mediaStorageDir.path + File.separator + "IMG_" + barcode + "_" + type + ".jpg")
        lastFileGeneratedPath = mediaFile.absolutePath


        return mediaFile
    }

    fun getOutputMediaFileUri(pictureUrl: String): Uri {
        return Uri.fromFile(getOutputMediaFile(pictureUrl))
    }

    private fun getOutputMediaFile(pictureUrl: String): File? {
        val mediaStorageDir = File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "UpdatePrices")
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null
            }
        }
        val fileName = pictureUrl.replaceAfter(".jpg", "").replaceBefore("IMG", "")
        val mediaFile = File(mediaStorageDir.path + File.separator + fileName)
        lastFileGeneratedPath = mediaFile.absolutePath
        return mediaFile
    }
}