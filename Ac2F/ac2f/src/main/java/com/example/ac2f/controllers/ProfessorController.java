package com.example.ac2f.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2f.dtos.ProfessorDTO;
import com.example.ac2f.services.ProfessorServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

  @Autowired
  ProfessorServiceImpl service;

  @PostMapping()
  public void inserir(@RequestBody ProfessorDTO professor) {
    service.inserir(professor);
  }

  @GetMapping()
  public List<ProfessorDTO> listarTodas() {
    return service.obterTodos();
  }
}
