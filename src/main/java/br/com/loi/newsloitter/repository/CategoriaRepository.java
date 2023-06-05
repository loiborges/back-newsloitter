package br.com.loi.newsloitter.repository;

import br.com.loi.newsloitter.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
