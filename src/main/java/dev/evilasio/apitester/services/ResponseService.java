package dev.evilasio.apitester.services;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class ResponseService {

    public Mono<Object> objResponse(Long delay, Object obj) {

        return Mono.justOrEmpty(obj).delaySubscription(Duration.ofSeconds(delay));
    }

    public Mono<String> stringResponse(Long delay, String text) {

        return Mono.justOrEmpty(text).delaySubscription(Duration.ofSeconds(delay));
    }
}
