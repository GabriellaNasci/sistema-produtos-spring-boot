package br.edu.ifsp.frameworkdemo.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import br.edu.ifsp.frameworkdemo.model.Produto;


@Repository
public class ProdutoRepository {

    private final Map<Long, Produto> dados = new LinkedHashMap<>();
    private final AtomicLong sequencia = new AtomicLong();
   
    public List <Produto> listar(){
        return new ArrayList<>(dados.values());
    }


    public Optional<Produto> buscarPorId(Long id){
        return Optional.ofNullable(dados.get(id));

    }

    public Produto salvar(Produto produto){
        if(produto.getId() == null){
            produto.setId(sequencia.incrementAndGet());
        }
        dados.put(produto.getId(), produto);
        return produto;
    }


    public void excluir(Long id){
        dados.remove(id);
    }

}
