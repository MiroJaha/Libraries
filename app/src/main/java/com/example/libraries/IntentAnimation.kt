package com.example.libraries

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrConfig
import com.r0adkll.slidr.model.SlidrInterface
import com.r0adkll.slidr.model.SlidrPosition

class IntentAnimation : AppCompatActivity() {

    private lateinit var slidr: SlidrInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent_anim)

        val config = SlidrConfig.Builder()
            .primaryColor(resources.getColor(android.R.color.holo_green_dark))
            .secondaryColor(resources.getColor(android.R.color.holo_blue_bright))
            .position(SlidrPosition.LEFT) //LEFT|RIGHT|TOP|BOTTOM|VERTICAL|HORIZONTAL
            .sensitivity(1f)
            .scrimColor(Color.RED)
            .scrimStartAlpha(0.8f)
            .scrimEndAlpha(0f)
            .velocityThreshold(2400F)
            .distanceThreshold(0.25f)
            .edge(false) //true|false
            .edgeSize(0.18f) // The % of the screen that counts as the edge, default 18%
            .build() //You can add .listener(new SlidrListener(){...}) before build

        slidr= Slidr.attach(this,config)

    }

    fun lockSlid(view: View) {
        slidr.lock()
    }
    fun unlockSlid(view: View) {
        slidr.unlock()
    }
}