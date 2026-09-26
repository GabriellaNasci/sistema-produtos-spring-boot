package br.edu.ifsp.frameworkdemo.model;

public class ResumoEstoque {

    private Integer quantidadeProdutos;
    private Integer quantidadeItens;
    private Double valorTotalEstoque;
    private Integer produtosSemEstoque;
    private Integer produtosEstoqueBaixo;

    public ResumoEstoque( Integer quantidadeProdutos, Integer quantidadeItens, Double valorTotalEstoque, Integer produtosSemEstoque, 
                          Integer produtosEstoqueBaixo) {
    
        this.quantidadeProdutos = quantidadeProdutos;
        this.quantidadeItens = quantidadeItens;
        this.valorTotalEstoque = valorTotalEstoque;
        this.produtosSemEstoque = produtosSemEstoque;
        this.produtosEstoqueBaixo = produtosEstoqueBaixo;
    }

    public Integer getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(Integer quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public Integer getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(Integer quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public Double getValorTotalEstoque() {
        return valorTotalEstoque;
    }

    public void setValorTotalEstoque(Double valorTotalEstoque) {
        this.valorTotalEstoque = valorTotalEstoque;
    }

    public Integer getProdutosSemEstoque() {
        return produtosSemEstoque;
    }

    public void setProdutosSemEstoque(Integer produtosSemEstoque) {
        this.produtosSemEstoque = produtosSemEstoque;
    }

    public Integer getProdutosEstoqueBaixo() {
        return produtosEstoqueBaixo;
    }

    public void setProdutosEstoqueBaixo(Integer produtosEstoqueBaixo) {
        this.produtosEstoqueBaixo = produtosEstoqueBaixo;
    }

    

    

}

