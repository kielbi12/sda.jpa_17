package io.kielbi.sda.sda.jpa_17.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")

public class RootController {

    @GetMapping
    String hello(){
        return "hello";
    }


}
