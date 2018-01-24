package com.matera.cursoFerias.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class Carro {

    @NotNull(message = "Houve um problema interno. Por favor, contate o administrador.")
    private String id;

    @Min(value = 1900, message = "Infelizmente não aceitamos veículos anteriores à 1900.")
    @Null
    private Integer ano;

    @NotNull(message = "Por favor, informe a marca do veículo")
    private String marca;

    @NotNull(message = "Por favor, informe o valor desejado pelo veículo.")
    private Double valor;

    @NotNull(message = "Por favor, informe a cor do veículo.")
    private String cor;

    public Carro(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
