package com.hyuki.korelloflux.infrastructure.mongo

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories


@Configuration
@EnableMongoAuditing
@EnableReactiveMongoRepositories(basePackages = ["com.hyuki.korelloflux"])
class ReactiveMongoConfiguration() : AbstractReactiveMongoConfiguration() {
    override fun getDatabaseName(): String {
        return "korello"
    }

    override fun reactiveMongoClient(): MongoClient {
        return MongoClients.create(mongoClientSettings())

    }

    override fun mongoClientSettings(): MongoClientSettings {
        val connection = ConnectionString("mongodb://hyuki.app:9091/korello")
        return MongoClientSettings.builder().applyConnectionString(connection).build()
    }
}