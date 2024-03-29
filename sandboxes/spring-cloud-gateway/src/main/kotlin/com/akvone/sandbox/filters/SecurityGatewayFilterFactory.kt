package com.akvone.sandbox.filters

import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

/**
 * Throws 403 if request contains "allowed=false" query param
 */
@Component
class SecurityGatewayFilterFactory : AbstractGatewayFilterFactory<Any>(Any::class.java) {

    override fun apply(config: Any): GatewayFilter {
        return SecurityGatewayFilter()
    }

    class SecurityGatewayFilter : GatewayFilter {
        private val httpStatusIfNotAllowed = HttpStatus.FORBIDDEN

        override fun filter(exchange: ServerWebExchange, chain: GatewayFilterChain): Mono<Void> {
            return if (isAllowed(exchange)) {
                chain.filter(exchange)
            } else {
                ServerWebExchangeUtils.setResponseStatus(exchange, httpStatusIfNotAllowed)
                exchange.response.setComplete()
            }
        }

        private fun isAllowed(exchange: ServerWebExchange): Boolean {
            val queryParam = exchange.request.queryParams.getFirst("allowed")
            return queryParam != "false"
        }

    }

}
