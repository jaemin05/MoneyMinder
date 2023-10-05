package com.example.marketcustomer.domain.model

import com.example.marketcustomer.domain.model.OrderDocument
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface UserElasticsearchRepository : ElasticsearchRepository<UserDocument, Int>, CustomOrderSearchRepository