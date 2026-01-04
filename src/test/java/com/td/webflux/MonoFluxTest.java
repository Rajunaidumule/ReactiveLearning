package com.td.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MonoFluxTest {

    @Test
    public void testMono(){
        // created a publisher which will publish "Raju"
       Mono<String> publisherString = Mono.just("Raju").log();

       // now we need to subscribe this publisher to see the output

        AtomicReference<String> name = new AtomicReference<>("");
        publisherString.subscribe(s -> {
              System.out.println("Received :"+s);
              name.set(s.toUpperCase());
        });

        System.out.println(name);
        // now subscribe method will come to subscribe  and it will call onSubscribe method
        // then it will go the subscription interface request method
        // then it will call onNext method to publish the data
        // then it will call onComplete method to complete the data publishing
        // if any error occurs it will call onError method


    }

    @Test
    public void testFlux() {
        // publishing multiple strings
        Flux<String> publisherStrings =Flux.just("Raju", "Naidu", "Singampalli")
                .concatWithValues("Kumar")
        .log();

        // while subscribing we can get each string one by one

        List<String > names = new ArrayList<>();
        publisherStrings.subscribe(s->{
            names.add(s);
        });

        System.out.println(names);
    }
}
