package br.com.tech4padoca.produtos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4padoca.produtos.Model.Produtos;
import br.com.tech4padoca.produtos.Repository.ProdutosRepository;
import br.com.tech4padoca.produtos.Shared.ProdutosCompletoDTO;
import br.com.tech4padoca.produtos.Shared.ProdutosDTO;

@Service
public class ProdutosServiceImpl implements ProdutosService{
@Autowired
private ProdutosRepository repositorio;

    @Override
    public List<ProdutosDTO> obterTodos() {
return repositorio.findAll().stream().
                   map(p -> new ProdutosDTO(p.getNome(), p.getCodigo(), p.getPreco()))
                   .toList();
    }

    @Override
    public Optional<ProdutosCompletoDTO> obterPorId(String id) {
        Optional<Produtos>produtos = repositorio.findById(id);
        if (produtos.isPresent()) {
            return Optional.of(new ProdutosCompletoDTO(produtos.get().getId(),
                                                       produtos.get().getCodigo(),
                                                       produtos.get().getTipo(),
                                                       produtos.get().getNome(), 
                                                       produtos.get().getPreco(), 
                                                       produtos.get().getQtdEstoque()));            
        }
        return Optional.empty();

    }

    /*@Override
public Optional<ProdutosCompletoDTO> obterPorCodigo(Integer codigo) {
    Optional<Produtos> produtos = repositorio.findByCodigo(codigo);
    if (produtos.isPresent()) {
        return Optional.of(new ProdutosCompletoDTO(produtos.get().getId(), produtos.get().getCodigo(),
                                                   produtos.get().getTipo(), produtos.get().getNome(), produtos.get().getPreco(),
                                                   produtos.get().getQtdEstoque()));
    }
    return Optional.empty();
}*/

    @Override
    public ProdutosCompletoDTO cadastrar(ProdutosCompletoDTO produtosDto) {
Produtos p = new Produtos(produtosDto);
repositorio.save(p);
return new ProdutosCompletoDTO(p.getId(),p.getCodigo(),
                               p.getTipo(),p.getNome(),
                               p.getPreco(),p.getQtdEstoque());

    }

    @Override
    public Optional<ProdutosCompletoDTO> atualizarPorId(String id, ProdutosCompletoDTO dto) {
Optional<Produtos>produtos = repositorio.findById(id);
if (produtos.isPresent()) {
    Produtos produtosAtualizar = new Produtos(dto);
    produtosAtualizar.setId(id);
    repositorio.save(produtosAtualizar);
    
    return Optional.of(new ProdutosCompletoDTO(produtosAtualizar.getId(),
                                                produtosAtualizar.getCodigo(),
                                                produtosAtualizar.getTipo(),
                                                produtosAtualizar.getNome(),
                                                produtosAtualizar.getPreco(),
                                                produtosAtualizar.getQtdEstoque()));
}
    return Optional.empty();
    }

    @Override
    public void excluirPorId(String id) {
repositorio.deleteById(id);

    }
    
}
