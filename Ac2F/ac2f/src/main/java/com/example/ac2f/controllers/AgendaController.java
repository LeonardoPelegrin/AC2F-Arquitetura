package com.example.ac2f.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ac2f.dtos.AgendaDTO;
import com.example.ac2f.services.AgendaServiceImpl;


import java.util.List;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

  @Autowired
  AgendaServiceImpl service;

  @PostMapping
  public void inserir(@RequestBody AgendaDTO agenda) {
    service.inserir(agenda);
  }

  @GetMapping
  public List<AgendaDTO> obterTodos() {
    return service.obterTodos();
  }
}
