package com.matera.cursoFerias.repository;

import com.matera.cursoFerias.model.Carro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.util.StringUtils.isEmpty;

@Repository
public class CarroRepository {

    final List<Carro> carros = new ArrayList<Carro>();

    public Carro save(Carro carro) {
        carros.add(carro);
        return carro;
    }


    public Carro findById(String id) {
        final Optional<Carro> carro = carros
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if (!carro.isPresent())
            throw new RuntimeException("Não foi encontrado um carro com o id " + id);

        return carro.get();

    }

    public List<Carro> findBy(String nome, String cor, Integer ano, Double valor) {
        Stream<Carro> stream = carros.stream();

        if (!isEmpty(nome)) {
            stream = stream.filter(c -> c.getMarca().equalsIgnoreCase(nome));
        }

        if (!isEmpty(cor)) {
            stream = stream.filter(c -> c.getCor().equalsIgnoreCase(cor));
        }

        if (ano != null) {
            stream = stream.filter(c -> c.getAno().equals(ano));
        }

        if (valor != null) {
            stream = stream.filter(c -> c.getValor().equals(valor));
        }

        return stream.collect(Collectors.toList());
    }

    public List<Carro> findAll() {
        return carros;
    }

    public void remove(String id) {
        final Carro carro = findById(id);
        carros.remove(carro);
    }
}
