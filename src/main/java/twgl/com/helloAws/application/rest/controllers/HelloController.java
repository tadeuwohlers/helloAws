package twgl.com.helloAws.application.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        //log this call to the console
        System.out.println("GET called on /api/v1/hello end-point updated");
        return "Hello world again";
    }
}