package com.ifs21001.pampraktikum8

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Dino(
    var nama:String,
    var photo:Int,
    var deskripsi:String,
    var karakteristik:String,
    var kelompok:String,
    var habitat:String,
    var makanan:String,
    var panjang:String,
    var tinggi:String,
    var bobot:String,
    var kelemahan:String,
) : Parcelable