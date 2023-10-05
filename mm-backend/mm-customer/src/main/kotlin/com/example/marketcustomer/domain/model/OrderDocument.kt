package com.example.marketcustomer.domain.model

import org.springframework.data.elasticsearch.annotations.*
import java.time.LocalDateTime
import javax.persistence.Id

@Document(indexName = "order")
@Mapping(mappingPath = "elastic/order-mapping.json")
@Setting(settingPath = "elastic/order-setting.json")
class UserDocument(
    @Id
    val id: Int = 0,

    val name: String,

    val price: Int,

    @Field(type = FieldType.Date, format = [DateFormat.date_hour_minute_second_millis, DateFormat.epoch_millis])
    val createdAt: LocalDateTime,
)