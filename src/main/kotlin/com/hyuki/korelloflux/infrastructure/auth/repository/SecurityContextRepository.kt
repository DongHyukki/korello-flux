package com.hyuki.korelloflux.infrastructure.auth.repository

import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextImpl
import org.springframework.security.web.server.context.ServerSecurityContextRepository
import org.springframework.stereotype.Repository
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Repository
class SecurityContextRepository : ServerSecurityContextRepository {
    override fun save(exchange: ServerWebExchange?, context: SecurityContext?): Mono<Void> {
        return Mono.empty()
    }

    override fun load(exchange: ServerWebExchange?): Mono<SecurityContext> {
        val token = exchange?.request?.headers?.get(HttpHeaders.AUTHORIZATION) ?: "ANONYMOUS"
        return Mono.just(SecurityContextImpl(makeAuthentication()))
    }

    private fun makeAuthentication(): UsernamePasswordAuthenticationToken {
        return UsernamePasswordAuthenticationToken(null, null, roleToAuthorities("USER_ROLE"))
    }

    private fun roleToAuthorities(role: String): MutableList<SimpleGrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority(role))
    }
}