package com.mokhtar.robustatask.data.product


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.mokhtar.robustatask.data.product.Product
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductsResponse(

    @SerializedName("number")
    val number: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<Product>,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("page")
    val page: Int,
):Parcelable