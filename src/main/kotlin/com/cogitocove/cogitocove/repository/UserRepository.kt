package com.cogitocove.cogitocove.repository

import com.cogitocove.cogitocove.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}
