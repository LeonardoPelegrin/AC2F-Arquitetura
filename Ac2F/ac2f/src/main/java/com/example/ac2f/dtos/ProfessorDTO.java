package com.example.ac2f.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessorDTO {
  private Long id;
  private String nome;
  private String cpf;
  private String endereco;
  private String telefone;
  private List<Long> cursosId;
  private List<Long> agendaId;
}

