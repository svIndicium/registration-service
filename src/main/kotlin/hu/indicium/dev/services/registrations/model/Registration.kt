package hu.indicium.dev.services.registrations.model

import hu.indicium.dev.model.users.Personal
import hu.indicium.dev.model.users.Contact
import io.micronaut.core.annotation.Creator
import io.micronaut.core.annotation.Introspected
import org.bson.codecs.pojo.annotations.BsonCreator

@Introspected
data class Registration @Creator @BsonCreator constructor(
    val personal: Personal,
    val contact: Contact,
    val studyType: String,
    val receivesNewsletter: Boolean,
    val identifier: String?
)
