package com.example.flashlight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.flashlight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var flashClass: FlashClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        flashClass = FlashClass(this)
    }

    fun onClickFlash(view: View){
        if(flashClass.isFlash_status){
            flashClass.flashOff()
            binding.button.text = getString(R.string.on)
            binding.button.setBackgroundResource(R.drawable.circle_green)
        }else{
            flashClass.flashOn()
            binding.button.text = getString(R.string.off)
            binding.button.setBackgroundResource(R.drawable.circle_red)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(flashClass.isFlash_status){
            flashClass.flashOff()
        }
    }
}