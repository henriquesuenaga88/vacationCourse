package com.matera.cursoFerias.service;

import com.matera.cursoFerias.model.Carro;
import com.matera.cursoFerias.repository.CarroRepository;
import com.matera.cursoFerias.request.CarroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    @Autowired
    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public Carro cadastrarCarro(CarroRequest carroRequest) {
        final Carro carro = new Carro(UUID.randomUUID().toString());
        carro.setAno(carroRequest.getAno());
        carro.setCor(carroRequest.getCor());
        carro.setMarca(carroRequest.getNome());
        carro.setValor(carroRequest.getValor());

        carroRepository.save(carro);

        return carro;
    }

    public Carro recuperarCarro(String id) {
        return carroRepository.findById(id);
    }

    public List<Carro> recuperarPor(String nome, String cor, Integer ano, Double valor) {
        return carroRepository.findBy(nome, cor, ano, valor);
    }


    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }

    public void remover(String id) {
        carroRepository.remove(id);
    }
}
