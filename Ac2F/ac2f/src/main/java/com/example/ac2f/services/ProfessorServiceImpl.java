package com.example.ac2f.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2f.dtos.ProfessorDTO;
import com.example.ac2f.models.Curso;
import com.example.ac2f.models.Professor;
import com.example.ac2f.repositories.CursoRepository;
import com.example.ac2f.repositories.ProfessorRepository;



@Service
public class ProfessorServiceImpl implements ProfessorService {

  @Autowired
  private ProfessorRepository professorRepository;

  @Autowired
  CursoRepository cursoRepository;

  public ProfessorServiceImpl(ProfessorRepository professorRepository) {
    this.professorRepository = professorRepository;
  }

  @Override
  public void inserir(ProfessorDTO dto) {
    Professor professor = new Professor();
    List<Curso> cursos = dto.getCursosId().stream().map( c -> cursoRepository.findById(c).orElseThrow()).collect(Collectors.toList());
    professor.setNome(dto.getNome());
    professor.setCpf(dto.getCpf());
    professor.setEndereco(dto.getEndereco());
    professor.setTelefone(dto.getTelefone());
    professorRepository.save(professor);
    professor.setCursos(cursos);
    professorRepository.save(professor);
  }

  @Override
  public List<ProfessorDTO> obterTodos() {
    List<ProfessorDTO> professor = professorRepository.findAll().stream().map(p -> {
      return ProfessorDTO.builder()
          .id(p.getId())
          .nome(p.getNome())
          .cpf(p.getCpf())
          .endereco(p.getEndereco())
          .telefone(p.getTelefone())
          .cursosId(p.getCursos() == null ? null : p.getCursos().stream().map(c -> c.getId()).collect(Collectors.toList()))
          .agendaId(p.getAgendas() == null ? null : p.getAgendas().stream().map(a -> a.getId()).collect(Collectors.toList()))
          .build();
    }).collect(Collectors.toList());

    return professor;
  }

  @Override
  public ProfessorDTO getById(Long id) {
    Professor p = professorRepository.findById(id).orElseThrow();

    return ProfessorDTO.builder()
        .id(p.getId())
        .nome(p.getNome())
        .cpf(p.getCpf())
        .endereco(p.getEndereco())
        .telefone(p.getTelefone())
        .cursosId(p.getCursos() == null ? null : p.getCursos().stream().map(c -> c.getId()).collect(Collectors.toList()))
        .agendaId(p.getAgendas() == null ? null : p.getAgendas().stream().map(a -> a.getId()).collect(Collectors.toList()))
        .build();
  }


}
