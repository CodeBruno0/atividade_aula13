package br.com.tech4padoca.vendas.Model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4padoca.vendas.Shared.VendasCompletoDTO;
import br.com.tech4padoca.vendas.Shared.VendasDTO;

@Document("vendas")
public class Vendas {
    @Id
    private String id; 
    private Integer codigoProduto;
    private String idProduto;
    private Double valor;
    private Integer qtdVendida;
    private Date dataVenda;

    public Vendas(){

    }

    public static Vendas fromVendasCompletoDTO(VendasCompletoDTO vendasDto){
        Vendas venda = new Vendas();
        venda.setId(vendasDto.id());
        venda.setCodigoProduto(vendasDto.codigoProduto());
        venda.setValor(vendasDto.valor());
        venda.setQtdVendida(vendasDto.qtdVendida());
        venda.setDataVenda(vendasDto.dataVenda());
        venda.setIdProduto(vendasDto.idProduto());
        return venda;
    }

    public static Vendas fromVendaDTO(VendasDTO vendaDto){
        Vendas venda = new Vendas();
        venda.setCodigoProduto(vendaDto.codigoProduto());
        venda.setId(vendaDto.id());
        venda.setQtdVendida(vendaDto.qtdVendida());
        return venda;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQtdVendida() {
        return qtdVendida;
    }

    public void setQtdVendida(Integer qtdVendida) {
        this.qtdVendida = qtdVendida;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }
}
