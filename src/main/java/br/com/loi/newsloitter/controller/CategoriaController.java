package br.com.loi.newsloitter.controller;

import br.com.loi.newsloitter.DTO.CategoriaDTO;
import br.com.loi.newsloitter.entity.Categoria;
import br.com.loi.newsloitter.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> findAllCategorias(){
        return categoriaService.findAllCategorias();
    }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Integer id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public Categoria save(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.save(categoriaDTO);
    }

    @PutMapping("/{id}")
    public Categoria update(@RequestBody CategoriaDTO categoriaDTO, @PathVariable Integer id){
        return categoriaService.update(categoriaDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoriaService.delete(id);
    }

}
