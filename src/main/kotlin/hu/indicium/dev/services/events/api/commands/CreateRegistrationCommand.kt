package hu.indicium.dev.services.events.api.commands

import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Past

data class CreateRegistrationCommand(
    @get:Valid
    val personal: Personal,
    @get:Valid
    val contact: Contact,
    @get:NotBlank
    val studyType: String,
    val receivesNewsletter: Boolean
) {
    data class Personal(
        @get:Past
        val birthdate: LocalDate,
        @get:Valid
        val name: Name
    ) {
        data class Name(
            @get:NotBlank
            val firstName: String,
            val infix: String?,
            @get:NotBlank
            val lastName: String
        )
    }

    data class Contact(
        @get:NotBlank
        val email: String,
        val phoneNumber: String?
    )
}
