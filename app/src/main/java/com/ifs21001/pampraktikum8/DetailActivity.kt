package com.ifs21001.pampraktikum8

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ifs21001.pampraktikum8.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var fruit: Fruit? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fruit = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_FRUIT,
                Fruit::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_FRUIT)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (fruit != null) {
            supportActionBar?.title = "${fruit!!.name}"
            loadData(fruit!!)
        } else {
            finish()
        }
    }

    private fun loadData(fruit: Fruit) {
        binding.ivDetailIcon.setImageResource(fruit.icon)
        binding.tvDetailName.text = fruit.name
        binding.tvDetailDescription.text = fruit.description
        binding.tvDetailCharacteristic.text = fruit.characteristic
        binding.tvDetailKelompok.text = fruit.kelompok
        binding.tvDetailHabitat.text = fruit.habitat
        binding.tvDetailMakanan.text = fruit.makanan
        binding.tvDetailPanjang.text = fruit.panjang
        binding.tvDetailTinggi.text = fruit.tinggi
        binding.tvDetailBobot.text = fruit.bobot
        binding.tvDetailKelemahan.text = fruit.kelemahan
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_FRUIT = "extra_fruit"
    }
}
