package br.com.tech4padoca.vendas.Shared;

import java.util.Date;

import br.com.tech4padoca.vendas.Model.Vendas;

public record VendasCompletoDTO(String id,
                                Integer codigoProduto,
                                Double valor,
                                Integer qtdVendida,
                                Date dataVenda,
                                String idProduto) {

    public static VendasCompletoDTO fromVenda(Vendas venda){
        return new VendasCompletoDTO(venda.getId(),venda.getCodigoProduto(),
                                     venda.getValor(), venda.getQtdVendida(),
                                     venda.getDataVenda(),
                                     venda.getIdProduto());
    }
}
