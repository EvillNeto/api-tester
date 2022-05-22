package dev.evilasio.apitester.services;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class ResponseService {

    public Mono<Object> objResponse(Long delay, Object obj) {

        Mono<Object> objMono = Mono.justOrEmpty(obj).delaySubscription(Duration.ofSeconds(delay));

        return objMono;
    }

    public Mono<String> stringResponse(Long delay, String text) {

        Mono<String> monoString = Mono.justOrEmpty(text).delaySubscription(Duration.ofSeconds(delay));

        return monoString;
    }

}
