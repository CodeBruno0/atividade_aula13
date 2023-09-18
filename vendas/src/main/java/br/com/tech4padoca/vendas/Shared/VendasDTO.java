package br.com.tech4padoca.vendas.Shared;

import br.com.tech4padoca.vendas.Model.Produtos;
import br.com.tech4padoca.vendas.Model.Vendas;


public record VendasDTO(String id,
                        Integer codigoProduto,
                        Integer qtdVendida) {
        public static VendasDTO fromVendas(Vendas venda, Produtos produto){
            return new VendasDTO(venda.getId(),
                                 venda.getCodigoProduto(),
                                 venda.getQtdVendida());
        }
    
}
