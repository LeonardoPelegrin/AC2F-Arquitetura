package com.example.ac2f.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2f.dtos.CursoDTO;
import com.example.ac2f.models.Curso;
import com.example.ac2f.repositories.CursoRepository;
import com.example.ac2f.repositories.ProfessorRepository;


@Service
public class CursoServiceImpl implements CursoService {
  @Autowired
  private CursoRepository cursoRepository;

  @Autowired
  ProfessorRepository professorRepository;

  public CursoServiceImpl(CursoRepository cursoRepository) {
    this.cursoRepository = cursoRepository;
  }

  @Override
  public void inserir(CursoDTO cursoDto) {
    Curso curso = new Curso();
    curso.setDescricao(cursoDto.getDescricao());
    curso.setCargaHoraria(cursoDto.getCargaHoraria());
    curso.setObjetivo(cursoDto.getObjetivo());
    curso.setEmenta(cursoDto.getEmenta());

    cursoRepository.save(curso);
  }

  @Override
  public List<CursoDTO> obterTodos() {
    List<CursoDTO> cursos = cursoRepository.findAll().stream().map(c -> {
      return CursoDTO.builder()
          .id(c.getId())
          .descricao(c.getDescricao())
          .cargaHoraria(c.getCargaHoraria())
          .objetivo(c.getObjetivo())
          .ementa(c.getEmenta())
          .professoresId(c.getProfessores() == null ? null
              : c.getProfessores().stream().map(p -> p.getId()).collect(Collectors.toList()))
          .agendasId(
              c.getAgendas() == null ? null : c.getAgendas().stream().map(a -> a.getId()).collect(Collectors.toList()))
          .build();
    }).collect(Collectors.toList());
    return cursos;
  }

  @Override
  public CursoDTO obterPorId(Long id) {
    Curso c = cursoRepository.findById(id).orElseThrow();

    return CursoDTO.builder()
        .id(c.getId())
        .descricao(c.getDescricao())
        .cargaHoraria(c.getCargaHoraria())
        .objetivo(c.getObjetivo())
        .ementa(c.getEmenta())
        .professoresId(c.getProfessores() == null ? null
            : c.getProfessores().stream().map(p -> p.getId()).collect(Collectors.toList()))
        .agendasId(
            c.getAgendas() == null ? null : c.getAgendas().stream().map(a -> a.getId()).collect(Collectors.toList()))
        .build();
  }

}
