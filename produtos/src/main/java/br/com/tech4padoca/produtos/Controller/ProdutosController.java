package br.com.tech4padoca.produtos.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4padoca.produtos.Service.ProdutosService;
import br.com.tech4padoca.produtos.Shared.ProdutosCompletoDTO;
import br.com.tech4padoca.produtos.Shared.ProdutosDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosService service;

    @GetMapping
    private ResponseEntity<List<ProdutosDTO>> obterTodos(){
        return new ResponseEntity<>(service.obterTodos(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ProdutosCompletoDTO> obterPorId(@PathVariable String id){
        if(service.obterPorId(id).isPresent()){
            return new ResponseEntity<>(service.obterPorId(id).get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    private ResponseEntity<ProdutosCompletoDTO> cadastrar(
                                                          @RequestBody  ProdutosCompletoDTO produtos){
        return new ResponseEntity<>(service.cadastrar(produtos), HttpStatus.CREATED);
    } 
    @DeleteMapping
    private ResponseEntity<Void> excluirPorId(@PathVariable String id){
        service.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    private ResponseEntity<ProdutosCompletoDTO> atualizarPorId(
                                                               @PathVariable String id,
                                                               @RequestBody ProdutosCompletoDTO produtos){
        Optional<ProdutosCompletoDTO> produtosAtualizar= service.atualizarPorId(id, produtos);
        if (produtosAtualizar.isPresent()) {
            return new ResponseEntity<>(produtosAtualizar.get(),HttpStatus.OK);
                        
        }return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    
                                                               }
}
