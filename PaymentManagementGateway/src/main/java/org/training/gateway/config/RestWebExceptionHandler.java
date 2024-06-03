package org.training.gateway.config;


import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
@Order(-2)
class RestWebExceptionHandler implements WebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        String message = Objects.isNull(ex.getMessage()) ? "An Error Occurred" : ex.getMessage();
        ResponseStatusException responseStatusException = new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());

        if(ex.getMessage().equals("missing authorization header")){
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            responseStatusException =  new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage());
        } else {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            responseStatusException =  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, message);
        }
        return Mono.error(responseStatusException);
    }

}
