package br.com.tech4padoca.vendas.Service;

import java.util.List;
import java.util.Optional;

import br.com.tech4padoca.vendas.Shared.VendasCompletoDTO;
import br.com.tech4padoca.vendas.Shared.VendasDTO;

public interface VendasService {
    List<VendasCompletoDTO> obterTodas();
    Optional<VendasDTO> obterVendaPorId(String id);
    VendasCompletoDTO cadastrarVenda(VendasCompletoDTO vendasDto);
    Optional<VendasCompletoDTO> atualizarVendaPorId(String id);
    void excluirPorId(String id);
}
