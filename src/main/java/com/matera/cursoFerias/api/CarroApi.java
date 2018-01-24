package com.matera.cursoFerias.api;

import com.matera.cursoFerias.model.Carro;
import com.matera.cursoFerias.request.CarroRequest;
import com.matera.cursoFerias.response.CarroResponse;
import com.matera.cursoFerias.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "lojacarros")
public class CarroApi {


    @Autowired
    private CarroService carroService;

    @PostMapping(
            path = "/",
            consumes = "application/json"
    )
    public ResponseEntity<Object> novo(@RequestBody CarroRequest request) {
        final Carro carro = carroService.cadastrarCarro(request);
        return ResponseEntity.created(URI.create("/detalhes" + carro.getId())).body(carro.getId());
    }

    @DeleteMapping(path = "/remover")
    public ResponseEntity<Object> remover(@RequestParam String id) {
        carroService.remover(id);
        return ResponseEntity.ok().header("Location", "listar").build();
    }

    @GetMapping(
            path = "/todos",
            produces = "application/json"
    )
    public ResponseEntity<List> listar() {
        final List<Carro> todos = carroService.listarTodos();
        List<CarroResponse> response = todos
            .stream()
            .map(c -> new CarroResponse(c))
            .collect(Collectors.toList());
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping(
            path = "/{id}",
            produces = "application/json"
    )
    public CarroResponse recuperar(@PathVariable String id) {
        final Carro carro = carroService.recuperarCarro(id);
        return new CarroResponse(carro);
    }

    @GetMapping(
            path = "/filtrar",
            produces = "application/json")
    public ResponseEntity<List> filtrar(
            @RequestParam(required = false) String cor,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Integer ano,
            @RequestParam(required = false) Double valor) {
        final List<Carro> carroList = carroService.recuperarPor(nome, cor, ano, valor);
        return ResponseEntity.ok().body(carroList);
    }

}
