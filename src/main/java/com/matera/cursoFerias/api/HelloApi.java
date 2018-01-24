package com.matera.cursoFerias.api;

import com.matera.cursoFerias.request.HelloRequest;
import com.matera.cursoFerias.response.HelloResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("api")
public class HelloApi {

    @GetMapping(
            path = "/aula/hello/v1",
            produces = {
                    "text/plain"
            })
    public ResponseEntity<String> sayHello(
            @RequestParam(
                    required = false,
                    defaultValue = "Aspect"
            ) String name) {
        return status(200).body("Hello " + name);
    }


    @GetMapping(
            path="aula/hello/v2",
            produces = {
                    "application/json"
            })
    public ResponseEntity<HelloResponse> sayHelloV2() {
        HelloResponse helloResponse = new HelloResponse("ihuuu", "versão 2");
        return ResponseEntity.ok(helloResponse);
    }

    @PostMapping(
            path="aula/hello/v2",
            produces = {
                    "application/json"
            },
            consumes = {
                    "application/xml"
            })
    public ResponseEntity<HelloResponse> sayHelloV3(@RequestBody HelloRequest request) {
        HelloResponse helloResponse = new HelloResponse(request.getName(), "eee");
        return ResponseEntity.ok(helloResponse);
    }

    @GetMapping(path = "redirect")
    public ResponseEntity redirect() {
        return ResponseEntity.status(307).header("Location", "http://www.google.com").build();
    }
}
