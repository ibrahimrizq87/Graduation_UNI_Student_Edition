package com.uni.unistudent.ui

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import com.uni.unistudent.R

class CustomDialog(private val activity: FragmentActivity) {
    private var waitDialog: AlertDialog? =null
    private val builder = AlertDialog.Builder(activity)
    private val inflater = activity.layoutInflater


    fun showWait() {

        builder.setView(inflater.inflate(R.layout.wait_dialog, null))
        builder.setCancelable(false)
        waitDialog = builder.create()
        waitDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        waitDialog?.show()
     }
   private fun hideWaitDialog(){
       waitDialog?.dismiss()

    }

    fun showSuccess() {

            hideWaitDialog()


        builder.setView(inflater.inflate(R.layout.success_dialog, null))
        builder.setCancelable(true)
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.findViewById<Button>(R.id.ok_btn).setOnClickListener { dialog.dismiss() }

    }

    fun showFailed() {
        hideWaitDialog()
        builder.setView(inflater.inflate(R.layout.failed_dialog, null))
        builder.setCancelable(true)
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.findViewById<Button>(R.id.ok_failed_btn).setOnClickListener { dialog.dismiss() }
    }

}