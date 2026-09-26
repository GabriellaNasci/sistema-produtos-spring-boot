package br.edu.ifsp.frameworkdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifsp.frameworkdemo.model.Produto;
import br.edu.ifsp.frameworkdemo.model.ResumoEstoque;

@Service
public class ProdutoService {

    private final List<Produto> produtos = new ArrayList<>();
    private Long proximoId = 1L;

    public ProdutoService() {
        produtos.add(
        new Produto(proximoId++, "Notebook", 3500.00, 5, "Informatica")
        );

        produtos.add(
            new Produto(
        proximoId++, "Mouse", 80.00, 20, "Informatica")
        );

        produtos.add(
        new Produto(
            proximoId++, "Mesa", 700.00, 3, "Moveis")
        );
    }

    public List<Produto> listar() {
        return produtos;
    }

    public Produto buscarPorId(Long id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }
        return null;
    }

    public Produto cadastrar(Produto produto) {
        produto.setId(proximoId++);
        produtos.add(produto);
        return produto;
    }

    public Produto atualizar(Long id, Produto novoProduto) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                produto.setNome(novoProduto.getNome());
                produto.setPreco(novoProduto.getPreco());
                produto.setQuantidade(novoProduto.getQuantidade());
                produto.setCategoria(novoProduto.getCategoria());
                return produto;
            }
        }
        return null;
    }

    public boolean excluir(Long id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                produtos.remove(produto);
                return true;
            }
        }
        return false;
    }

    public List<Produto> buscarPorNome(String nome) {
        List<Produto> resultado = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(produto);
            }
        }
        return resultado;
    }

    public List<Produto> buscarPorCategoria(String nome) {
        List<Produto> resultado = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase(nome)) {
                resultado.add(produto);
            }
        }
        return resultado;
    }

    public List<Produto> estoqueBaixo() {
        List<Produto> resultado = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getQuantidade() < 5) {
                resultado.add(produto);
            }
        }
        return resultado;
    }

    public Double valorEstoque(Long id) {
        Produto produto = buscarPorId(id);
        if (produto == null) {
            return null;
        }
        return produto.getPreco() * produto.getQuantidade();
    }

    public Produto entradaEstoque (Long id,Integer quantidade) {
        Produto produto = buscarPorId(id);
        if (produto == null) {
        return null;
        }
        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade de entrada deve ser maior que zero.");
        }
        produto.setQuantidade(produto.getQuantidade() + quantidade);
        return produto;
    }

    public Produto saidaEstoque(Long id, Integer quantidade) {
        Produto produto = buscarPorId(id);
        if (produto == null) {
            return null;
        }
        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade de saida deve ser maior que zero.");
        }
        if (produto.getQuantidade() < quantidade) {
            throw new IllegalArgumentException("Estoque insuficiente para realizar a saida.");
        }
        produto.setQuantidade(produto.getQuantidade() - quantidade);
        return produto;
    }

    public Produto aplicarDesconto(Long id, Double percentual) {
        Produto produto = buscarPorId(id);
        if (produto == null) {
            return null;
        }
        if (percentual == null || percentual <= 0 || percentual > 50) {
            throw new IllegalArgumentException("O desconto deve ser maior que 0 e no maximo 50.");
        }
        Double desconto = produto.getPreco() * percentual / 100;
        produto.setPreco(produto.getPreco() - desconto);
        return produto;
    }

    public ResumoEstoque estatisticas() {
        Integer quantidadeProdutos = produtos.size();
        Integer quantidadeItens = 0;
        Double valorTotalEstoque = 0.0;
        Integer produtosSemEstoque = 0;
        Integer produtosEstoqueBaixo = 0;
        for (Produto produto : produtos) {
            quantidadeItens += produto.getQuantidade();
            valorTotalEstoque += produto.getPreco() * produto.getQuantidade();
            if (produto.getQuantidade() == 0) {
                produtosSemEstoque++;
            }
            if (produto.getQuantidade() < 5) {
                produtosEstoqueBaixo++;
            }
        }
        return new ResumoEstoque(quantidadeProdutos, quantidadeItens,valorTotalEstoque,
                                produtosSemEstoque,produtosEstoqueBaixo);
    }


    //desafio 3 - versao 5
    public Produto reajuste(Long id, Double percentualReajuste){
        Produto produto = buscarPorId(id);
        if (produto == null) {
            return null;
        }
        if (percentualReajuste == null || percentualReajuste <= 0 || percentualReajuste > 50) {
            throw new IllegalArgumentException("O valor do percentual do reajuste deve ser maior que zero.");
        }
        Double precoReajuste = produto.getPreco() * percentualReajuste / 100;
        produto.setPreco(produto.getPreco() + precoReajuste);
        return produto;
    }

    //desafio 2 - versao 4
    public Produto maisCaro(){
        Produto produtoMaisCaro = produtos.getFirst();
        for (Produto produto : produtos) {
            if (produto.getPreco() >produtoMaisCaro.getPreco()) {
                produtoMaisCaro = produto;
            }
        }
        return produtoMaisCaro;
    }


    //desafio 3 - versao 4
    public List<Produto> semEstoque(){
        List<Produto> resultado = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getQuantidade() == 0) {
                resultado.add(produto);
            }
        }
        return resultado;
    }

}//fecha classe
    