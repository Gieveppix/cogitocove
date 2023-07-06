package com.cogitocove.cogitocove.model

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    private val username: String,

    @Column(nullable = false)
    private val password: String,

    @Column(nullable = false)
    private val role: String,

    @Column(nullable = false)
    private val enabled: Boolean = true,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "authorities",
        joinColumns = [JoinColumn(name = "username", referencedColumnName = "username")]
    )
    @Column(name = "authority")
    private val authorities: List<String> = emptyList()
) : UserDetails {
    override fun getUsername() = username
    override fun getPassword() = password
    override fun isEnabled() = enabled
    override fun getAuthorities() = authorities.map { SimpleGrantedAuthority(it) }
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
}
