package com.example.marketcustomer.domain.model

import com.example.marketcustomer.domain.presentation.dto.OrderResponseList
import com.example.marketcustomer.presentation..dto.OrderListResponse
import com.example.marketcustomer.presentation..dto.OrderListResponse.OrderResponse
import com.example.marketcustomer.domain.model.OrderDocument
import com.example.marketcustomer.domain.model.OrderEntity
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.query.Criteria
import org.springframework.data.elasticsearch.core.query.CriteriaQuery
import org.springframework.stereotype.Component

    @Component
    class CustomOrderSearchRepositoryImpl(
        private val elasticsearchOperations: ElasticsearchOperations
    ): CustomOrderSearchRepository {
        override fun searchByName(name: String): OrderListResponse {
            val criteria = Criteria.where("name").contains(name)
            val query = CriteriaQuery(criteria)
            val search = elasticsearchOperations.search(query, OrderDocument::class.java)
            val orders = search.map {
                OrderResponse(
                    id = it.content.id,
                    name = it.content.name,
                    price = it.content.price,
                )
            }.toList()

            return OrderListResponse(orders)
        }
    }