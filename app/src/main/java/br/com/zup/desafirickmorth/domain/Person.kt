package br.com.zup.desafirickmorth.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    var image: Int,
    var name: String,
    var status: String,
    var species: String,
    var gender: String
) :
    Parcelable {
}