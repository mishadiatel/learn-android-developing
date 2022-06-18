package com.example.yes_no

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.example.yes_no.databinding.ActivityMainBinding
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var fnum: Int = 0
    var lnum: Int = 0
    var bool: Boolean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.M)
    fun random(view: View){
        if (bool == true){
            val count = Random.nextBoolean()
            if (count) binding.tvRandom.text = getString(R.string.yes)
            else binding.tvRandom.text = getString(R.string.no)
        }else{
            when {
                fnum < lnum -> {
                    val count = ThreadLocalRandom.current().nextInt(fnum, lnum+1)
                    binding.tvRandom.text = count.toString()   
                }
                fnum == lnum ->{
                    binding.tvRandom.text = fnum.toString()
                }
                else -> {
                    Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()

                }
            }

        }
    }
    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.M)
    fun onClickYesNo(view: View){
        bool = true
        binding.apply {
            tvRandom.text = ""
            button.visibility = View.VISIBLE
            btn1min.visibility = View.INVISIBLE
            btn1plus.visibility = View.INVISIBLE
            btn2min.visibility = View.INVISIBLE
            btn2plus.visibility = View.INVISIBLE
            lnumb.visibility = View.INVISIBLE
            fnumb.visibility = View.INVISIBLE
            btnyasno.setTextColor(R.color.btnColor)
            btnrandomnum.setTextColor(Color.WHITE)
        }
    }
    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.M)
    fun onClickNumbers(view: View) {
        bool = false
        binding.apply {
            tvRandom.text = ""
            button.visibility = View.VISIBLE
            btn1min.visibility = View.VISIBLE
            btn1plus.visibility = View.VISIBLE
            btn2min.visibility = View.VISIBLE
            btn2plus.visibility = View.VISIBLE
            lnumb.visibility = View.VISIBLE
            fnumb.visibility = View.VISIBLE
            btnrandomnum.setTextColor(R.color.btnColor)
            btnyasno.setTextColor(Color.WHITE)
        }
    }
    fun onClickBtn1plus(view: View){
        fnum++
        binding.fnumb.text = fnum.toString()
    }
    fun onClickBtn1min(view: View){
        fnum--
        binding.fnumb.text = fnum.toString()
    }
    fun onClickBtn2plus(view: View){
        lnum++
        binding.lnumb.text = lnum.toString()
    }

    fun onClickBtn2min(view: View){
        lnum--
        binding.lnumb.text = lnum.toString()
    }

}