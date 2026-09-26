package br.edu.ifsp.frameworkdemo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;


public class Produto {

    private Long id;
    @NotBlank(message = "O nome e obrigatorio.")
    //desafio 1
    @Size(min = 3, max = 80, message = "O campo 'nome' deve ter entre {min} e {max} caracteres")
    private String nome;


    @NotNull(message = "O preco e obrigatorio.")
    @Positive(message = "O preco deve ser maior que zero.")
    private Double preco;

    @NotNull(message = "A quantidade e obrigatoria.")
    @PositiveOrZero(message = "A quantidade nao pode ser negativa.")
    private Integer quantidade;
    
    @NotBlank(message = "A categoria e obrigatoria.")
    //desafio 2
    @Size(max = 50, message = "O campo 'categoria' deve ter no máximo {max} caracteres")
    private String categoria;
    // construtores, getters e setters

    public Produto() {
    }

    public Produto(Long id, String nome, double preco, Integer quantidade, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
}
