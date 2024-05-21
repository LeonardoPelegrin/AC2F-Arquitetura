package com.example.ac2f.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2f.dtos.CursoDTO;
import com.example.ac2f.services.CursoServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

  @Autowired
  CursoServiceImpl service;

  @PostMapping()
  public void inserir(@RequestBody CursoDTO curso) {
    service.inserir(curso);
  }

  @GetMapping()
  public List<CursoDTO> listarTodas() {
    return service.obterTodos();
  }
}
