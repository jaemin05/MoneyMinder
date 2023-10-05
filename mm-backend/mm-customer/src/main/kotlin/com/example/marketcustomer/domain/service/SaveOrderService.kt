package com.example.marketcustomer.domain.service

import com.example.marketcustomer.domain.model.OrderEntity
import com.example.marketcustomer.domain.model.OrderDocument
import com.example.marketcustomer.domain.model.OrderRepository
import com.example.marketcustomer.domain.model.UserElasticsearchRepository
import org.springframework.stereotype.Service

@Service
class SaveOrderService(
    private val orderRepository: OrderRepository,
    private val orderElasticsearchRepository: OrderElasticsearchRepository,
    ) {

    fun saveOrder(orderEntity: OrderEntity) {
        orderRepository.save(orderEntity)
        orderElasticsearchRepository.deleteAll()
        saveOrderDocument()
    }

    private fun saveOrderDocument() {
        val orderDocument = orderRepository.findAll()
            .map {
                OrderDocument(
                    id = it.id,
                    name = it.name,
                    price = it.price,
                    createdAt = LocalDateTime.now(),
                )
            }.toList()
        orderElasticsearchRepository.saveAll(orderDocument)
    }
}