package com.bignerdranch.android.criminalintent

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.fragment.app.DialogFragment

private const val ARG_PHOTO = "photo"

class ZoomImageDialogFragment : DialogFragment() {

    companion object {
        fun newInstance(photoPath: String): ZoomImageDialogFragment {
            val args = Bundle().apply {
                putString(ARG_PHOTO, photoPath)
            }

            return ZoomImageDialogFragment().apply {
                arguments = args
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val imageFile = arguments?.getString(ARG_PHOTO)

        val rootView = LayoutInflater.from(activity).inflate(R.layout.fragment_dialog_zoom_image, null, false)
        val bitmap = getScaledBitmap(imageFile!!, activity!!)

        val imageView: ImageView = rootView.findViewById(R.id.zoomed_image) as ImageView

        imageView.setImageBitmap(bitmap)

        return AlertDialog.Builder(activity).run {
            setView(rootView)
            create()
        }
    }

}