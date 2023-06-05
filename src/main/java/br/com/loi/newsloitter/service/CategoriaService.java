package br.com.loi.newsloitter.service;

import br.com.loi.newsloitter.DTO.CategoriaDTO;
import br.com.loi.newsloitter.entity.Categoria;
import br.com.loi.newsloitter.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id).orElseThrow();
    }

    public Categoria save(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria(categoriaDTO);
        return categoriaRepository.save(categoria);
    }

    public Categoria update(CategoriaDTO categoriaDTO, Integer id) {
        Categoria categoria = findById(id);

        if (categoriaDTO.getDescricao() != null) {
            categoria.setDescricao(categoriaDTO.getDescricao());
        }

        return categoriaRepository.save(categoria);
    }

    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
