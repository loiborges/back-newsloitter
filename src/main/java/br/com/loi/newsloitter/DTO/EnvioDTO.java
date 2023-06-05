package br.com.loi.newsloitter.DTO;

import br.com.loi.newsloitter.entity.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@NoArgsConstructor
public class EnvioDTO {

    private Long idEnvio;
    private Cliente cliente;
    private Character status;
    private Date dataEnvio;
    private String msgErro;
}
