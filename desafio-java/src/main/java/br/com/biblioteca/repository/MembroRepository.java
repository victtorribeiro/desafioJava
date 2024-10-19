package br.com.biblioteca.repository;

import br.com.biblioteca.model.entity.Membro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepository extends JpaRepository<Membro, Long> {
}
