package com.matera.cursoFerias.response;

import com.matera.cursoFerias.model.Carro;

public class CarroResponse {

    private Integer ano;

    private String nome;

    private Double valor;

    private String cor;

    public CarroResponse(Carro carro) {
        this.ano = carro.getAno();
        this.nome = carro.getMarca();
        this.valor = carro.getValor();
        this.cor = carro.getCor();
    }

    public Integer getAno() {
        return ano;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public String getCor() {
        return cor;
    }
}
