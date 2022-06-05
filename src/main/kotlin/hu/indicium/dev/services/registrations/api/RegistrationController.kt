package hu.indicium.dev.services.registrations.api

import hu.indicium.dev.model.users.Contact
import hu.indicium.dev.model.users.Name
import hu.indicium.dev.model.users.Personal
import hu.indicium.dev.rest.HttpResponse
import hu.indicium.dev.rest.HttpResponse.Builder.Companion.created
import hu.indicium.dev.rest.HttpResponse.Builder.Companion.ok
import hu.indicium.dev.services.registrations.api.commands.CreateRegistrationCommand
import hu.indicium.dev.services.registrations.model.Registration
import hu.indicium.dev.structure.BaseController
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import javax.validation.Valid

@Controller
open class RegistrationController(private val registrationService: RegistrationService) : BaseController() {
    @Get
    @Secured("ADMIN")
    suspend fun registrations(): HttpResponse =
        registrationService.getRegistrations().let {
            ok()
                .data(it)
                .build()
        }

    @Post
    @Secured(SecurityRule.IS_ANONYMOUS)
    @Status(HttpStatus.CREATED)
    open suspend fun createRegistration(@Valid createRegistrationCommand: CreateRegistrationCommand): HttpResponse =
        Registration(
            Personal(
                Name(
                    createRegistrationCommand.personal.name.firstName,
                    createRegistrationCommand.personal.name.infix,
                    createRegistrationCommand.personal.name.lastName,
                ),
                createRegistrationCommand.personal.birthdate
            ),
            Contact(
                createRegistrationCommand.contact.email,
                createRegistrationCommand.contact.phoneNumber
            ),
            createRegistrationCommand.studyType,
            createRegistrationCommand.receivesNewsletter,
            null
        ).let {
            registrationService.storeRegistration(it).let {
                created()
                    .data(it)
                    .build()
            }
        }
}