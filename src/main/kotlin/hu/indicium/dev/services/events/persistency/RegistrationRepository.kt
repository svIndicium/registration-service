package hu.indicium.dev.services.events.persistency

import hu.indicium.dev.mongodb.BaseRepository
import hu.indicium.dev.mongodb.MongoConfig
import hu.indicium.dev.services.events.model.Registration
import jakarta.inject.Singleton
import org.litote.kmongo.coroutine.CoroutineClient

@Singleton
class RegistrationRepository(
    client: CoroutineClient,
    mongoConfig: MongoConfig
) : BaseRepository<Registration>(client, mongoConfig.database ?: "registrations", Registration::class) {
}