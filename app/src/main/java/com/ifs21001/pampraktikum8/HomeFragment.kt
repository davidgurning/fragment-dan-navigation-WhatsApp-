package com.ifs21001.pampraktikum8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21001.pampraktikum8.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), ListFruitAdapter.OnItemClickCallback {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var fruitAdapter: ListFruitAdapter
    private lateinit var fruitsList: ArrayList<Fruit> // Tidak perlu inisialisasi di sini

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fruitsList = getListFruits()
        setupRecyclerView()
    }
    private fun setupRecyclerView() {
        fruitAdapter = ListFruitAdapter(fruitsList)
        fruitAdapter.setOnItemClickCallback(this) // Set callback untuk item klik
        binding.rvFruits.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = fruitAdapter
        }
    }

    override fun onItemClicked(data: Fruit) {
        // Implementasi aksi saat item diklik di sini
        // Contoh: Menampilkan informasi detail buah
    }

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
    }

    private fun getListFruits(): ArrayList<Fruit> {
        val dataName =
            resources.getStringArray(R.array.fruit_name)
        val dataIcon =
            resources.obtainTypedArray(R.array.fruit_icon)
        val dataDescription =
            resources.getStringArray(R.array.fruit_description)
        val dataCharacteristic =
            resources.getStringArray(R.array.fruit_characteristic)
        val dataKelompok =
            resources.getStringArray(R.array.fruit_kelompok)
        val dataHabitat =
            resources.getStringArray(R.array.fruit_habitat)
        val dataMakanan =
            resources.getStringArray(R.array.fruit_makanan)
        val dataPanjang =
            resources.getStringArray(R.array.fruit_panjang)
        val dataTinggi =
            resources.getStringArray(R.array.fruit_tinggi)
        val dataBobot =
            resources.getStringArray(R.array.fruit_bobot)
        val dataKelemahan=
            resources.getStringArray(R.array.fruit_kelemahan)
        val listFruit = ArrayList<Fruit>()
        for (i in dataName.indices) {
            val fruit = Fruit(dataName[i],
                dataIcon.getResourceId(i, -1), dataDescription[i],
                dataCharacteristic[i], dataKelompok[i], dataHabitat[i], dataMakanan[i],dataPanjang[i], dataTinggi[i], dataBobot[i],
                dataKelemahan[i])
            listFruit.add(fruit)
        }
        // Penting untuk melepaskan sumber daya yang digunakan oleh dataIcon
        dataIcon.recycle()
        return listFruit
    }
}

