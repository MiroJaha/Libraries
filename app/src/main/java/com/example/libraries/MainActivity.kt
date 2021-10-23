package com.example.libraries

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.tapadoo.alerter.Alerter
import io.github.muddz.styleabletoast.StyleableToast
import yuku.ambilwarna.AmbilWarnaDialog
import yuku.ambilwarna.AmbilWarnaDialog.OnAmbilWarnaListener

class MainActivity : AppCompatActivity() {

    private var defaultColor=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        defaultColor= ContextCompat.getColor(this, R.color.white)

    }

    fun styleableToast(view: View) {
        StyleableToast.makeText(this,"Warning!!",R.style.mytoast).show()
    }

    fun slid(view: View) {
        val intent= Intent(this,IntentAnimation::class.java)
        startActivity(intent)
    }

    fun alert(view: View) {
        Alerter.create(this)
            .setTitle("Warning!!")
            .setText("COVID-19")
            .setIcon(R.drawable.ic_coronavirus)
            .setIconColorFilter(Color.parseColor("#722DD5"))
            .setBackgroundColorRes(android.R.color.holo_blue_bright)
            .setDuration(5000)
            .enableSwipeToDismiss()
            .enableProgress(true)
            .setProgressColorRes(R.color.black)
            .show()
    }

    fun pickColor(view: View) {
        val mainLay= findViewById<ConstraintLayout>(R.id.mainLay)
        val colorPicker= AmbilWarnaDialog(this,defaultColor, object: OnAmbilWarnaListener{
            override fun onCancel(dialog: AmbilWarnaDialog?) {
            }
            override fun onOk(dialog: AmbilWarnaDialog?, color: Int) {
                defaultColor= color
                mainLay.setBackgroundColor(defaultColor)
            }
        })
        colorPicker.show()
    }


}