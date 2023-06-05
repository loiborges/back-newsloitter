package br.com.loi.newsloitter.entity;

import br.com.loi.newsloitter.DTO.ClienteDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE", schema = "loi")
@Data
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ACEITE")
    private Character aceite;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
    private Categoria categoria;

    public Cliente(ClienteDTO clienteDTO) {
        this.idCliente = clienteDTO.getIdCliente();
        this.nome = clienteDTO.getNome();
        this.email = clienteDTO.getEmail();
        this.aceite = clienteDTO.getAceite();
        this.categoria = clienteDTO.getCategoria();
    }
}
