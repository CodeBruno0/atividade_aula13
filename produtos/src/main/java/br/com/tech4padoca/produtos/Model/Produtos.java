package br.com.tech4padoca.produtos.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4padoca.produtos.Shared.ProdutosCompletoDTO;

@Document("produtos")
public class Produtos {
    @Id
    private String id;
    private String nome;
    private Integer codigo;
    private Tipo tipo;
    private Integer qtdEstoque;
    private Double preco;

    public Produtos(){

    }

    public Produtos(ProdutosCompletoDTO dto){
        setId(dto.id());
        setCodigo(dto.codigo());
        setTipo(dto.tipo());
        setNome(dto.nome());
        setPreco(dto.preco());
        setQtdEstoque(dto.qtdEstoque());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
}
