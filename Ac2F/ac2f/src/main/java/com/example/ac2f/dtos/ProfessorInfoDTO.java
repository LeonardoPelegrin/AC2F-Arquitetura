package com.example.ac2f.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorInfoDTO{
  private Long id;
  private String nome;
  private String cpf;
  private String endereco;
  private String telefone;
}