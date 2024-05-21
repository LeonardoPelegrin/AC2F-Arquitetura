package com.example.ac2f.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2f.dtos.AgendaDTO;
import com.example.ac2f.models.Agenda;
import com.example.ac2f.models.Curso;
import com.example.ac2f.models.Professor;
import com.example.ac2f.repositories.AgendaRepository;
import com.example.ac2f.repositories.CursoRepository;
import com.example.ac2f.repositories.ProfessorRepository;


@Service
public class AgendaServiceImpl implements AgendaService {
  @Autowired
  private AgendaRepository agendaRepository;

  @Autowired
  private ProfessorRepository professorRepository;

  @Autowired
  private CursoRepository cursoRepository;

  public AgendaServiceImpl(AgendaRepository agendaRepository, ProfessorRepository professorRepository,
      CursoRepository cursoRepository) {
    this.agendaRepository = agendaRepository;
    this.professorRepository = professorRepository;
    this.cursoRepository = cursoRepository;
  }

  @Override
  public void inserir(AgendaDTO agendaDto) {
    Agenda agenda = new Agenda();
    Professor professor = professorRepository.findById(agendaDto.getProfessorId()).orElseThrow();
    Curso curso = cursoRepository.findById(agendaDto.getCursoId()).orElseThrow();

    agenda.setDataFinal(agendaDto.getDataFinal());
    agenda.setDataInicial(agendaDto.getDataInicial());
    agenda.setHorarioFinal(agendaDto.getHorarioFinal());
    agenda.setHorarioInicial(agendaDto.getHorarioInicial());
    agenda.setCidade(agendaDto.getCidade());
    agenda.setEstado(agendaDto.getEstado());
    agenda.setCep(agendaDto.getCep());
    agenda.setResumo(agenda.getResumo());
    agenda.setCurso(curso);
    agenda.setProfessor(professor);

    agendaRepository.save(agenda);
  }

  @Override
  public List<AgendaDTO> obterTodos() {
    List<AgendaDTO> agendas = agendaRepository.findAll().stream().map(a -> {
      return AgendaDTO.builder()
          .id(a.getId())
          .dataInicial(a.getDataInicial())
          .dataFinal(a.getDataFinal())
          .horarioInicial(a.getHorarioInicial())
          .horarioFinal(a.getHorarioFinal())
          .professorId(null)
          .cursoId(null)
          .cidade(a.getCidade())
          .cep(a.getCep())
          .estado(a.getEstado())
          .resumo(a.getResumo())
          .build();
    }).collect(Collectors.toList());

    return agendas;
  }

  @Override
  public AgendaDTO obterPorId(Long id) {
    Agenda a = agendaRepository.findById(id).orElseThrow();

    return AgendaDTO.builder()
        .id(a.getId())
        .dataInicial(a.getDataInicial())
        .dataFinal(a.getDataFinal())
        .horarioInicial(a.getHorarioInicial())
        .horarioFinal(a.getHorarioFinal())
        .professorId(a.getProfessor() == null ? null :a.getProfessor().getId())
        .cursoId(a.getCurso() == null ? null :a.getCurso().getId())
        .cidade(a.getCidade())
        .cep(a.getCep())
        .estado(a.getEstado())
        .resumo(a.getResumo())
        .build();
  }
  @Override
  public List<AgendaDTO> obterPorData(LocalDate localtime, long idProf) {
      List<AgendaDTO> agendas = agendaRepository.agendasProfessorPorData(idProf,localtime).stream().map(a -> {
          return AgendaDTO.builder()
                  .id(a.getId())
                  .dataInicial(a.getDataInicial())
                  .dataFinal(a.getDataFinal())
                  .horarioInicial(a.getHorarioInicial())
                  .horarioFinal(a.getHorarioFinal())
                  .professorId(a.getProfessor() == null ? null : a.getProfessor().getId())
                  .cursoId(a.getCurso() == null ? null : a.getCurso().getId())
                  .cidade(a.getCidade())
                  .cep(a.getCep())
                  .estado(a.getEstado())
                  .resumo(a.getResumo())
                  .build();
      }).collect(Collectors.toList());
  
      return agendas;
  }

  @Override
  public void editar(AgendaDTO agendaDto) {
    Agenda agenda = new Agenda();
    Professor professor = professorRepository.findById(agendaDto.getProfessorId()).orElseThrow();
    Curso curso = cursoRepository.findById(agendaDto.getCursoId()).orElseThrow();

    agenda.setDataFinal(agendaDto.getDataFinal());
    agenda.setDataInicial(agendaDto.getDataInicial());
    agenda.setHorarioFinal(agendaDto.getHorarioFinal());
    agenda.setHorarioInicial(agendaDto.getHorarioInicial());
    agenda.setCidade(agendaDto.getCidade());
    agenda.setEstado(agendaDto.getEstado());
    agenda.setCep(agendaDto.getCep());
    agenda.setResumo(agenda.getResumo());
    agenda.setCurso(curso);
    agenda.setProfessor(professor);
    agenda.setId(agendaDto.getId());

    agendaRepository.save(agenda);
  }
}
