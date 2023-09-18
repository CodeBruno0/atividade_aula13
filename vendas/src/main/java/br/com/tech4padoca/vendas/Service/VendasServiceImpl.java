package br.com.tech4padoca.vendas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4padoca.vendas.HttpClient.ProdutosClient;
import br.com.tech4padoca.vendas.Model.Produtos;
import br.com.tech4padoca.vendas.Model.Vendas;
import br.com.tech4padoca.vendas.Repository.VendasRepository;
import br.com.tech4padoca.vendas.Shared.VendasCompletoDTO;
import br.com.tech4padoca.vendas.Shared.VendasDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class VendasServiceImpl implements VendasService{
    
@Autowired
VendasRepository repositorio;

@Autowired
ProdutosClient cliente;

    @Override
    public List<VendasCompletoDTO> obterTodas() {
    return repositorio.findAll().stream()
                      .map(p -> VendasCompletoDTO.fromVenda(p))
                      .toList();

    }
    @CircuitBreaker(name= "obterPorId(String id)", fallbackMethod = "fallbackObterPorId")


    @Override
    public Optional<VendasDTO> obterVendaPorId(String id) {
Optional<Vendas> venda = repositorio.findById(id);

        if (venda.isPresent()) {
            Produtos produtos = cliente.obterPorId(venda.get().getIdProduto());
            return Optional.of(VendasDTO.fromVendas(venda.get(), produtos));

        }
        return Optional.empty();
    }

    @Override
    public VendasCompletoDTO cadastrarVenda(VendasCompletoDTO vendasDto) {
        Vendas vendas = Vendas.fromVendasCompletoDTO(vendasDto);
        Produtos produtos = cliente.obterPorId(vendas.getIdProduto());

        if (produtos.getQtdEstoque()>= 1) {
            repositorio.save(vendas);
            produtos.setQtdEstoque(produtos.getQtdEstoque()-1);
            cliente.atualizarPorId(produtos.getId(), produtos);
                        
        }
            return VendasCompletoDTO.fromVenda(vendas);
    }

    @Override
    public Optional<VendasCompletoDTO> atualizarVendaPorId(String id) {
        Optional <Vendas> vendas = repositorio.findById(id);
        if (vendas.isPresent()) {
            Vendas atualizarVenda = new Vendas();
             atualizarVenda.setId(id);
            return Optional.of(new VendasCompletoDTO(atualizarVenda.getId(), null, null, null, null, id));
                                                                 
        } 
        return Optional.empty();

    }
        
    @Override
    public void excluirPorId(String id) {
        repositorio.deleteById(id);
    }
    
}
