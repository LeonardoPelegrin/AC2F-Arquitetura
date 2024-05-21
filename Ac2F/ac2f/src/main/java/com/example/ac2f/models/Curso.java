package com.example.ac2f.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private long id;
  
  @ManyToMany(mappedBy = "cursos")
  List<Professor> professores;

  @ManyToMany(mappedBy = "curso")
  List<Agenda> agendas;

  @Column(nullable = false)
  String descricao;

  @Column(nullable = false)
  String cargaHoraria;

  @Column(nullable = false)
  String objetivo;

  @Column(nullable = false)
  String ementa;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public List<Professor> getProfessores() {
    return professores;
  }

  public void setProfessores(List<Professor> professores) {
    this.professores = professores;
  }

  public List<Agenda> getAgendas() {
    return agendas;
  }

  public void setAgendas(List<Agenda> agendas) {
    this.agendas = agendas;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(String cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }

  public String getObjetivo() {
    return objetivo;
  }

  public void setObjetivo(String objetivo) {
    this.objetivo = objetivo;
  }

  public String getEmenta() {
    return ementa;
  }

  public void setEmenta(String ementa) {
    this.ementa = ementa;
  }
}
