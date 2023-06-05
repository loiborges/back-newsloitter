package br.com.loi.newsloitter.DTO;

import br.com.loi.newsloitter.entity.Categoria;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {

    private Integer idCliente;
    private String nome;
    private String email;
    private Character aceite;
    private Categoria categoria;

}
