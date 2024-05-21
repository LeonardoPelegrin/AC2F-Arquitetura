package com.example.ac2f.services;


import java.util.List;
import com.example.ac2f.dtos.CursoDTO;


public interface CursoService {
  void inserir(CursoDTO cursoDto);
  List<CursoDTO> obterTodos();
  CursoDTO obterPorId(Long id);
}
