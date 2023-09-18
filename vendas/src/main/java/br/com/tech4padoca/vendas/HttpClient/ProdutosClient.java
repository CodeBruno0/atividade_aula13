package br.com.tech4padoca.vendas.HttpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tech4padoca.vendas.Model.Produtos;

 @FeignClient("produtos")
public interface ProdutosClient {
   @RequestMapping(method = RequestMethod.GET, value = "/produtos/{id}")
   Produtos obterPorId(@PathVariable String id);

   @RequestMapping(method = RequestMethod.PUT, value = "produtos/{id}")
   void atualizarPorId(@PathVariable String id, @RequestBody Produtos produtos);

}
