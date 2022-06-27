package com.example.yes_no


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.yes_no.databinding.ActivityMainBinding
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var fnum: Int = 0
    private var lnum: Int = 0
    private var bool: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.app_name)

        binding.bNav?.selectedItemId = R.id.btnyasno1
        binding.bNav?.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.btnyasno1 -> {
                    bool = 1
                    binding.apply {
                        tvRandom.text = ""
                        button.visibility = View.VISIBLE
                        btn1min.visibility = View.INVISIBLE
                        btn1plus.visibility = View.INVISIBLE
                        btn2min.visibility = View.INVISIBLE
                        btn2plus.visibility = View.INVISIBLE
                        lnumb.visibility = View.INVISIBLE
                        fnumb.visibility = View.INVISIBLE
                        backgroundColor?.visibility = View.INVISIBLE
                    }
                }
                R.id.btnrandomnum1 ->{
                    bool = 2
                    binding.apply {
                        tvRandom.text = ""
                        button.visibility = View.VISIBLE
                        btn1min.visibility = View.VISIBLE
                        btn1plus.visibility = View.VISIBLE
                        btn2min.visibility = View.VISIBLE
                        btn2plus.visibility = View.VISIBLE
                        lnumb.visibility = View.VISIBLE
                        fnumb.visibility = View.VISIBLE
                        backgroundColor?.visibility = View.INVISIBLE
                    }
                }
                R.id.btncolor ->{
                    bool = 3
                    binding.apply {
                        tvRandom.text = ""
                        button.visibility = View.VISIBLE
                        btn1min.visibility = View.INVISIBLE
                        btn1plus.visibility = View.INVISIBLE
                        btn2min.visibility = View.INVISIBLE
                        btn2plus.visibility = View.INVISIBLE
                        lnumb.visibility = View.INVISIBLE
                        fnumb.visibility = View.INVISIBLE
                        backgroundColor?.visibility = View.VISIBLE
                    }
                }
            }
            true
        }
    }

    fun random(view: View){
        if (bool == 1){
            val count = Random.nextBoolean()
            if (count) binding.tvRandom.text = getString(R.string.yes)
            else binding.tvRandom.text = getString(R.string.no)
        }else if (bool == 2){
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
        else if (bool == 3){
            val rnd = Random.Default
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            binding.backgroundColor?.setBackgroundColor(color)
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

    override fun onSaveInstanceState(outState: Bundle) = with(binding) {
        outState.run {
            putString("tvRandom", tvRandom.text.toString())
            putString("lnumb", lnumb.text.toString())
            putString("fnumb", fnumb.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) = with(binding) {
        super.onRestoreInstanceState(savedInstanceState)
        tvRandom.text = savedInstanceState.getString("tvRandom")
        lnumb.text = savedInstanceState.getString("lnumb")
        fnumb.text = savedInstanceState.getString("fnumb")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
        }
        return true
    }
}