package br.com.tech4padoca.vendas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4padoca.vendas.Service.VendasService;
import br.com.tech4padoca.vendas.Shared.VendasCompletoDTO;
import br.com.tech4padoca.vendas.Shared.VendasDTO;

@RestController
@RequestMapping("/vendas")
public class VendasController {
    @Autowired
    private VendasService service;

    @PostMapping
    public ResponseEntity<VendasCompletoDTO> cadastrarVenda(@RequestBody VendasCompletoDTO vendasDto){
        return new ResponseEntity<>(service.cadastrarVenda(vendasDto),HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<VendasCompletoDTO>> obterTodas(){
        return new ResponseEntity<>(service.obterTodas(), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    private ResponseEntity<VendasDTO>obterVendaPorId(@PathVariable String id){
        if (service.obterVendaPorId(id).isPresent()) {
            return new ResponseEntity<>(service.obterVendaPorId(id).get(), HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }
