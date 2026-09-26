package br.edu.ifsp.frameworkdemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.frameworkdemo.model.Produto;
import br.edu.ifsp.frameworkdemo.model.ResumoEstoque;
import br.edu.ifsp.frameworkdemo.service.ProdutoService;
import jakarta.validation.Valid;


@RestController 
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listar();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id) {
        Produto produto =produtoService.buscarPorId(id);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }


    @PostMapping
    public ResponseEntity<Produto> cadastrar(@Valid @RequestBody Produto produto) {
        Produto produtoCadastrado = produtoService.cadastrar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
        Produto atualizado = produtoService.atualizar(id, produto);
        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean excluiu = produtoService.excluir(id);
        if (!excluiu) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public List<Produto> buscarPorNome(@RequestParam String nome) {
        return produtoService.buscarPorNome(nome);
    }
    @GetMapping("/categoria")
    public List<Produto> buscarPorCategoria(@RequestParam String nome) {
        return produtoService.buscarPorCategoria(nome);
    }
    @GetMapping("/estoque-baixo")
    public List<Produto> estoqueBaixo() {
        return produtoService.estoqueBaixo();
    }

    @GetMapping("/{id}/valor-estoque")
    public ResponseEntity<Double> valorEstoque(@PathVariable Long id) {
        Double valor =produtoService.valorEstoque(id);
        if (valor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(valor);
    }

    @PutMapping("/{id}/entrada")
    public ResponseEntity<Produto> entradaEstoque(@PathVariable Long id,@RequestParam Integer quantidade) {
        Produto produto =produtoService.entradaEstoque(id,quantidade);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}/saida")
    public ResponseEntity<Produto> saidaEstoque(@PathVariable Long id,@RequestParam Integer quantidade) {
        Produto produto =produtoService.saidaEstoque(id,quantidade);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}/desconto")
    public ResponseEntity<Produto> aplicarDesconto(@PathVariable Long id,@RequestParam Double percentual) {
        Produto produto =produtoService.aplicarDesconto(id,percentual);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/estatisticas")
    public ResumoEstoque estatisticas() {
        return produtoService.estatisticas();
    }

    //desafio 3 - versao 5
    @PutMapping("/{id}/reajuste")
    public ResponseEntity<Produto> reajuste(@PathVariable Long id, @RequestParam Double percentualReajuste) {
        Produto produto = produtoService.reajuste(id, percentualReajuste);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produto);
    }

    //desafio 2 - versao 4
    @GetMapping("/mais-caro")
    public Produto maisCaro(){
        return produtoService.maisCaro();
    }

    //desafio 3 - versao 4
    @GetMapping("/sem-estoque")
    public List<Produto> semEstoque(){
        return produtoService.semEstoque();
    }
}
