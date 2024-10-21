package br.com.biblioteca.repository;

import br.com.biblioteca.model.entity.Membro;
import br.com.biblioteca.model.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepository extends JpaRepository<Membro, Long> {

    Membro findByProjeto(Projeto projeto);

}
