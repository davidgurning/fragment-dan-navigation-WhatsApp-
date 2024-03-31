package com.ifs21001.pampraktikum8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21001.pampraktikum8.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment(), ListDinoAdapter.OnItemClickCallback {
    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!
    private lateinit var dinoAdapter: ListDinoAdapter
    private lateinit var dinosList: ArrayList<Dino>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dinosList = getListDinos()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        dinoAdapter = ListDinoAdapter(dinosList)
        dinoAdapter.setOnItemClickCallback(this)
        binding.rvDinos.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dinoAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(data: Dino) {
        // Implementasi aksi saat item diklik di sini
        // Contoh: Menampilkan informasi detail buah
    }

    private fun getListDinos(): ArrayList<Dino> {
        val dataNama = resources.getStringArray(R.array.dino_nama)
        val dataPhoto = resources.obtainTypedArray(R.array.dino_photo)
        val dataDescription = resources.getStringArray(R.array.dino_deskripsi)
        val dataCharacteristic = resources.getStringArray(R.array.dino_karaktersitik)
        val dataKelompok = resources.getStringArray(R.array.dino_kelompok)
        val dataHabitat = resources.getStringArray(R.array.dino_habitat)
        val dataMakanan = resources.getStringArray(R.array.dino_makanan)
        val dataPanjang = resources.getStringArray(R.array.dino_panjang)
        val dataTinggi = resources.getStringArray(R.array.dino_tinggi)
        val dataBobot = resources.getStringArray(R.array.dino_bobot)
        val dataKelemahan = resources.getStringArray(R.array.dino_kelemahan)
        val listDino = ArrayList<Dino>()
        for (i in dataNama.indices) {
            val dino = Dino(
                dataNama[i],
                dataPhoto.getResourceId(i, -1),
                dataDescription[i],
                dataCharacteristic[i],
                dataKelompok[i],
                dataHabitat[i],
                dataMakanan[i],
                dataPanjang[i],
                dataTinggi[i],
                dataBobot[i],
                dataKelemahan[i]
            )
            listDino.add(dino)
        }
        dataPhoto.recycle()
        return listDino
    }
}

