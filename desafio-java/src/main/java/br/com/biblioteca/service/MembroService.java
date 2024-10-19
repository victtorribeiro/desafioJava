package br.com.biblioteca.service;

import br.com.biblioteca.repository.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final MembroRepository membroRepository;

}
