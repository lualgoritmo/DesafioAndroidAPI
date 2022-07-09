package br.com.zup.desafirickmorth.data.model


import com.google.gson.annotations.SerializedName

data class PersonResult(
    @SerializedName("gender")
    var gender: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("image")
    var image: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("species")
    var species: String,
    @SerializedName("status")
    var status: String,
)