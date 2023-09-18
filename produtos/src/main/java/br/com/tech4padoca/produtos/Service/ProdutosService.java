package br.com.tech4padoca.produtos.Service;

import java.util.List;
import java.util.Optional;

import br.com.tech4padoca.produtos.Shared.ProdutosCompletoDTO;
import br.com.tech4padoca.produtos.Shared.ProdutosDTO;

public interface ProdutosService {
    List<ProdutosDTO> obterTodos();
    Optional<ProdutosCompletoDTO> obterPorId(String id);
    //Optional<ProdutosCompletoDTO>obterPorCodigo(Integer codigo);
    ProdutosCompletoDTO cadastrar(ProdutosCompletoDTO produtos);
    Optional<ProdutosCompletoDTO> atualizarPorId(String id, ProdutosCompletoDTO produtos);
    void excluirPorId(String id);
    

}
