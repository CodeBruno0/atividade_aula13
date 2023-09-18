package br.com.tech4padoca.vendas.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4padoca.vendas.Model.Vendas;

@Repository
public interface VendasRepository extends MongoRepository<Vendas, String>{
    
}
