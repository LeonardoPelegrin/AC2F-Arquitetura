package com.example.ac2f.services;

import com.example.ac2f.dtos.AgendaDTO;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public interface AgendaService {
  void inserir(AgendaDTO agendaDto);
  List<AgendaDTO> obterTodos();
  AgendaDTO obterPorId(Long id);
  List<AgendaDTO> obterPorData(LocalDate localtime, long idProf);
  void editar(AgendaDTO agendaDto);
}
