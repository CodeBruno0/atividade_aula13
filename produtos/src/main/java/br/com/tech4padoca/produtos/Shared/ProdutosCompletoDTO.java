package br.com.tech4padoca.produtos.Shared;

import br.com.tech4padoca.produtos.Model.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProdutosCompletoDTO(String id,
                                  @NotEmpty(message="O codigo deve ser preenchido")
                                  Integer codigo,
                                  @NotNull(message="Deve informar um tipo valido: DOCE, SALGADO ou BEBIDA.")
                                  Tipo tipo,
                                  @NotBlank(message="O nome do produto esta em branco.")
                                  String nome,
                                  @Positive(message="O valor deve ser maior que zero.")
                                  Double preco,
                                  @NotNull(message="Deve ser informado uma quantidade de produtos.")
                                  Integer qtdEstoque) {
    
}
