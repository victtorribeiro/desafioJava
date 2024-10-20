package br.com.biblioteca.repository;

import br.com.biblioteca.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findAllByGerenteIsTrue();
}
