package hu.indicium.dev.services.events.api

import hu.indicium.dev.services.events.model.Registration
import hu.indicium.dev.services.events.persistency.RegistrationRepository
import hu.indicium.dev.structure.BaseService
import jakarta.inject.Singleton

@Singleton
open class RegistrationService(
    private val registrationRepository: RegistrationRepository
) : BaseService() {
    open suspend fun storeRegistration(registration: Registration): Registration? =
        registrationRepository.save(registration)

    open suspend fun getRegistrations(): List<Registration> =
        registrationRepository.findAll()
}