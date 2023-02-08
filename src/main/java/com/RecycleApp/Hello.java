package com.RecycleApp;

import org.springframework.stereotype.Component;

import com.RecycleApp.model.Greeting;
import com.RecycleApp.model.User;

import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class Hello implements Function<Mono<User>, Mono<Greeting>> {

    public Mono<Greeting> apply(Mono<User> mono) {
        return mono.map(user -> new Greeting("Hello, " + user.getName() + "!\n"));
    }
}