package com.example.scaneer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import com.example.scaneer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            val animation = AnimationUtils.loadAnimation(this, R.anim.slide_animation)
            binding.imageView.startAnimation(animation)



        // Handler yarating va asosiy tsikldan foydalaning
        handler = Handler(Looper.getMainLooper())

        // Kechiktirilgan harakatni boshlang
        handler.postDelayed({
            // Ushbu blok kechikish muddati tugagandan so'ng amalga oshiriladi
            // Tranzaktsiyalaringizni shu yerda qiling
            doSomething()
        }, 2000) // 2000 millisekund (2 soniya) kechikish vaqti

    }

    private fun doSomething() {
        // Kerakli amallaringizni bu erda bajarishingiz mumkin
        val intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Handler'ni bekor qilish
        handler.removeCallbacksAndMessages(null)
    }
}