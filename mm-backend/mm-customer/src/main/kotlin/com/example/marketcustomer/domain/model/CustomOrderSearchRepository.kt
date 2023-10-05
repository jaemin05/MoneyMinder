package com.example.marketcustomer.domain.model

import com.example.marketcustomer.domain.presentation.dto.OrderResponseList

interface CustomOrderSearchRepository {
    fun searchByName(name: String): OrderListResponse
}