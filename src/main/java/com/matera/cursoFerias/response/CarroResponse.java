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

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
