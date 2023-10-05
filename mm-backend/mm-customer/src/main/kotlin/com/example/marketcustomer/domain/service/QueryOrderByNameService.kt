package com.example.marketcustomer.domain.service

import com.example.marketcustomer.domain.model.OrderElasticsearchRepository
import com.example.marketcustomer.domain.model.OrderRepository
import com.example.marketcustomer.domain.presentation.dto.OrderListResponse
import org.springframework.cache.annotation.CacheEvict
import org.springframework.stereotype.Service

@Service
class QueryOrderByNameService(
    private val orderRepository: OrderRepository,
    private val orderElasticsearchRepository: OrderElasticsearchRepository,
    ) {

    fun getOrderByName(name: String): OrderListResponse = orderElasticsearchRepository.searchByName(name)
}
