package hu.indicium.dev.services.events.model

import hu.indicium.dev.model.users.Personal
import io.micronaut.core.annotation.Creator
import io.micronaut.core.annotation.Introspected
import org.bson.codecs.pojo.annotations.BsonCreator

@Introspected
data class Registration @Creator @BsonCreator constructor(
    val personal: Personal
)
