package dev.evilasio.apitester.controllers;

import java.time.Duration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.evilasio.apitester.services.ResponseService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class ResponseControler {

    private final ResponseService service;

    @RequestMapping()
    ResponseEntity<Mono<Object>> response(@RequestParam(name = "delay", defaultValue = "0") Long delay,
            @RequestParam(name = "response_code", defaultValue = "200") int statusCode) {

        return ResponseEntity.status(statusCode).body(Mono.empty().delaySubscription(Duration.ofSeconds(delay)));
    }

    @RequestMapping("/body")
    ResponseEntity<Mono<Object>> bodyResponse(@RequestParam(name = "delay", defaultValue = "0") Long delay,
            @RequestParam(name = "response_code", defaultValue = "200") int statusCode, @RequestBody Object obj) {

        return ResponseEntity.status(statusCode).body(service.objResponse(delay, obj));
    }

    @RequestMapping("/text")
    ResponseEntity<Mono<String>> textV2Response(@RequestParam(name = "delay", defaultValue = "0") Long delay,
            @RequestParam(name = "response_code", defaultValue = "200") int statusCode,
            @RequestBody String text) {

        return ResponseEntity.status(statusCode).body(service.stringResponse(delay, text));
    }
}
