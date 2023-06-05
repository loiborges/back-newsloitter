package br.com.loi.newsloitter.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ENVIO", schema = "loi")
@Data
@NoArgsConstructor
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENVIO")
    private Integer idEnvio;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @Column(name = "STATUS")
    private Character status;

    @Column(name = "DATA_ENVIO", columnDefinition = "DATE")
    private Date dataEnvio;

    @Column(name = "MSG_ERRO")
    private String msgErro;

}
