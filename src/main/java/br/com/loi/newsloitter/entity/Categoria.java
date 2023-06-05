package br.com.loi.newsloitter.entity;

import br.com.loi.newsloitter.DTO.CategoriaDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORIA", schema = "loi")
@Data
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIA")
    private Integer idCategoria;

    @Column(name = "DESCRICAO")
    private String descricao;

    public Categoria(CategoriaDTO categoriaDTO) {
        this.idCategoria = categoriaDTO.getIdCategoria();
        this.descricao = categoriaDTO.getDescricao();
    }
}
