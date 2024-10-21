package br.com.biblioteca.service;

import br.com.biblioteca.model.entity.Pessoa;
import br.com.biblioteca.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestPessoaService {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    Pessoa pessoa;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        pessoa = new Pessoa();

        pessoa.setId(1L);
        pessoa.setNome("Pessoa Teste");
        pessoa.setGerente(true);
    }

    @Test
    void testSalvarPessoa() {
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        Pessoa pessoaSalva = pessoaService.salvarPessoa(pessoa);

        assertNotNull(pessoaSalva);
        assertEquals("Pessoa Teste", pessoaSalva.getNome());
        verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test
    void testListGerente() {
        List<Pessoa> gerentes = new ArrayList<>();

        gerentes.add(pessoa);

        when(pessoaRepository.findAllByGerenteIsTrue()).thenReturn(gerentes);

        List<Pessoa> listaGerentes = pessoaService.listGerente();

        assertNotNull(listaGerentes);
        assertEquals(1, listaGerentes.size());
        assertTrue(listaGerentes.get(0).getGerente());

        verify(pessoaRepository, times(1)).findAllByGerenteIsTrue();
    }

}
