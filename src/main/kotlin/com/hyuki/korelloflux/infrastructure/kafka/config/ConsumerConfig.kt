package com.hyuki.korelloflux.infrastructure.kafka.config

import com.hyuki.korelloflux.presentation.dto.EventDTO
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@Configuration
class ConsumerConfig {

    @Bean
    fun initEventConsumer(): DefaultKafkaConsumerFactory<String, EventDTO> {
        val deserializer = JsonDeserializer(EventDTO::class.java)
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*")
        deserializer.setUseTypeMapperForKey(true)

        return DefaultKafkaConsumerFactory(
            mapOf(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to deserializer
            ), StringDeserializer(), deserializer
        )
    }
}