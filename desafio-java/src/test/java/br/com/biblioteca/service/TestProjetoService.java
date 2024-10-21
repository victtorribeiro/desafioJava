package br.com.biblioteca.service;

import br.com.biblioteca.enums.StatusEnum;
import br.com.biblioteca.model.dto.ProjetoDTO;
import br.com.biblioteca.model.entity.Projeto;
import br.com.biblioteca.repository.ProjetoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestProjetoService {

    @InjectMocks
    private ProjetoService projetoService;

    @Mock
    private ProjetoRepository projetoRepository;

    @Mock
    private MembroService membroService;

    private ProjetoDTO projetoDTO;
    private Projeto projeto;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        projetoDTO = new ProjetoDTO();
        projetoDTO.setIdGerente(1L);
        projetoDTO.setNome("Projeto Teste");
        projetoDTO.setStatus(StatusEnum.PLANEJADO);

        projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("Projeto Teste");
        projeto.setStatus(StatusEnum.PLANEJADO);
    }

    @Test
    void testSalvarProjeto() {
        when(projetoRepository.save(any(Projeto.class))).thenReturn(projeto);

        Projeto projetoSalvo = projetoService.salvarProjeto(projetoDTO);

        assertNotNull(projetoSalvo);
        assertEquals(projetoDTO.getNome(), projetoSalvo.getNome());
        verify(projetoRepository, times(1)).save(any(Projeto.class));
    }

    @Test
    void testListarProjetos() {
        when(projetoRepository.findAll()).thenReturn(Arrays.asList(projeto));

        List<Projeto> listaProjetos = projetoService.listarProjetos();

        assertFalse(listaProjetos.isEmpty());
        assertEquals(1, listaProjetos.size());
        assertEquals(projeto.getNome(), listaProjetos.get(0).getNome());
        verify(projetoRepository, times(1)).findAll();
    }

    @Test
    void testAlterarProjeto() {
        when(projetoRepository.save(any(Projeto.class))).thenReturn(projeto);

        Projeto projetoAlterado = projetoService.alterarProjeto(1L, projetoDTO);

        assertNotNull(projetoAlterado);
        assertEquals(1L, projetoAlterado.getId());
        assertEquals(projetoDTO.getNome(), projetoAlterado.getNome());
        verify(projetoRepository, times(1)).save(any(Projeto.class));
    }

    @Test
    void testBuscarProjetoId() {
        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));

        Projeto projetoBuscado = projetoService.buscarProjetoId(1L);

        assertNotNull(projetoBuscado);
        assertEquals(projeto, projetoBuscado);
        verify(projetoRepository, times(1)).findById(1L);
    }

    @Test
    void testBuscarProjetoIdNaoEncontrado() {
        when(projetoRepository.findById(1L)).thenReturn(Optional.empty());

        Projeto projetoBuscado = projetoService.buscarProjetoId(1L);

        assertNull(projetoBuscado);
        verify(projetoRepository, times(1)).findById(1L);
    }

    @Test
    void testDeletarProjetoComSucesso() {
        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));

        ResponseEntity<String> response = projetoService.deletarProjeto(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(membroService, times(1)).deletarMembro(projeto);
        verify(projetoRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeletarProjetoNaoEncontrado() {
        when(projetoRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<String> response = projetoService.deletarProjeto(1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(membroService, never()).deletarMembro(any(Projeto.class));
        verify(projetoRepository, never()).deleteById(1L);
    }

    @Test
    void testDeletarProjetoComStatusInvalido() {
        projeto.setStatus(StatusEnum.INICIADO);
        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));

        ResponseEntity<String> response = projetoService.deletarProjeto(1L);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(membroService, never()).deletarMembro(projeto);
        verify(projetoRepository, never()).deleteById(1L);
    }

}
