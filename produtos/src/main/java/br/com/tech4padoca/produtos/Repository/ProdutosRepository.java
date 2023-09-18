package br.com.tech4padoca.produtos.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4padoca.produtos.Model.Produtos;

public interface ProdutosRepository extends MongoRepository<Produtos,String>{

    
    
}
