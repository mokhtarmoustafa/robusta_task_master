package com.mokhtar.robustatask.data.remote.api

import com.mokhtar.robustatask.data.product.ProductsResponse
import com.mokhtar.robustatask.util.BASE_URL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {

    @GET(BASE_URL)
    suspend fun getProducts( @Query("query") query: String,
                             @Query("page") page: Int): Response<ProductsResponse>
}