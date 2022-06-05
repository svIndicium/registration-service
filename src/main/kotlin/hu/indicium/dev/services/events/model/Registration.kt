package hu.indicium.dev.services.events.model

import hu.indicium.dev.model.users.Name
import io.micronaut.core.annotation.Creator
import io.micronaut.core.annotation.Introspected
import org.bson.codecs.pojo.annotations.BsonCreator
import java.time.LocalDate

@Introspected
data class Registration @Creator @BsonCreator constructor(
    val name: Name,
    val birthdate: LocalDate
)
