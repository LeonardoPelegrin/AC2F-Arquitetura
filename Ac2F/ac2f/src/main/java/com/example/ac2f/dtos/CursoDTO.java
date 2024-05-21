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
public class CursoDTO {
  private Long id;
  private String descricao;
  private String cargaHoraria;
  private String objetivo;
  private String ementa;
  private List<Long> professoresId;
  private List<Long> agendasId;
}
