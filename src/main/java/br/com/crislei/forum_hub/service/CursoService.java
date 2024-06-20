package br.com.crislei.forum_hub.service;


import br.com.crislei.forum_hub.domain.Curso;
import br.com.crislei.forum_hub.dto.request.CursoDto;
import br.com.crislei.forum_hub.dto.response.CursoIdDto;
import br.com.crislei.forum_hub.repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;


    @Transactional
    public Long saveCurso(CursoDto cursoDto) {
        // Validate DTO fields
        if (cursoDto.nome() == null || cursoDto.categoria() == null) {
            throw new IllegalArgumentException("Nome and categoria fields are required.");
        }

        // Create Curso entity from DTO
        Curso curso = new Curso();
        curso.setNome(cursoDto.nome());
        curso.setCategoria(cursoDto.categoria());

        // Save curso to repository
        Curso savedCurso = repository.save(curso);
        return savedCurso.getId();
    }

    public Page<CursoIdDto> getAllCursos(Pageable pageable) {
        Page<Curso> cursosPage = repository.findAll(pageable);
        return cursosPage.map(cursos -> new CursoIdDto(
                cursos.getId(), cursos.getNome(),
                cursos.getCategoria()));
    }


    public void updateCurso(Long cursoId,
                            CursoIdDto cursoIdDto) {
        Optional<Curso> optional = repository.findById(cursoId);
        if (optional.isEmpty()) {
            throw new IllegalStateException("Curso not found with ID: " + cursoId);
        }
        Curso existingCurso = optional.get();

        existingCurso.setNome(cursoIdDto.nome());
        existingCurso.setCategoria(cursoIdDto.categoria());

        repository.save(existingCurso);
    }

    public boolean existsById(Long cursoId) {
        return repository.existsById(cursoId);
    }
}
