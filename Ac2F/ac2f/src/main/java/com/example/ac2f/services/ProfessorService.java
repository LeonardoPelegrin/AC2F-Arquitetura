package com.example.ac2f.services;

import java.util.List;

import com.example.ac2f.dtos.ProfessorDTO;


public interface ProfessorService {
  void inserir(ProfessorDTO dto);
  List<ProfessorDTO> obterTodos();
  ProfessorDTO getById(Long id);
}
