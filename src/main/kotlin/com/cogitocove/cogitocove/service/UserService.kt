package com.cogitocove.cogitocove.service

import com.cogitocove.cogitocove.repository.UserRepository
import com.cogitocove.cogitocove.model.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import jakarta.annotation.PostConstruct

@Service
class UserService(
    private val userRepository: UserRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder
) {

    @PostConstruct
    fun init() {
        val adminUser = User(
            username = "admin",
            password = bCryptPasswordEncoder.encode("admin123"),
            role = "ROLE_ADMIN"
        )

        if (userRepository.findByUsername(adminUser.username) == null) {
            userRepository.save(adminUser)
        }
    }
}