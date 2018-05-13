package com.example.bernardoaltamirano.quiniela.util

import android.content.Intent
import android.provider.MediaStore
import com.bluelinelabs.conductor.Controller

/**
 * Created by icaboalo on 02/03/18.
 */
object CameraUtils {

    fun startCamera(context: Controller, requestCode: Int, pictureUrl: String) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, FileUtils.getOutputMediaFileUri(pictureUrl)) // set the image file name
        if (intent.resolveActivity(context.activity?.packageManager) != null) {
            context.startActivityForResult(intent, requestCode)
        }
    }

    fun startCamera(context: Controller, requestCode: Int, barcode: String, type: String) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, FileUtils.getOutputMediaFileUri(barcode, type)) // set the image file name
        if (intent.resolveActivity(context.activity?.packageManager) != null) {
            context.startActivityForResult(intent, requestCode)
        }
    }
}