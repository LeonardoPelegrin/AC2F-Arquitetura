package com.example.ac2f.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_agenda")
public class Agenda {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private long id;
  
  @Column(nullable = false)
  LocalDate dataInicial;

  @Column(nullable = false)
  LocalDate dataFinal;

  @Column(nullable = false)
  LocalTime horarioInicial;

  @Column(nullable = false)
  LocalTime horarioFinal;

  @ManyToOne
  @JoinColumn(name = "professor_id")
  private Professor professor;

  @ManyToOne
  @JoinColumn(name = "curso_id")
  private Curso curso;

  @Column(nullable = false)
  String cidade;

  @Column(nullable = false)
  String estado;

  @Column(nullable = false)
  String cep;

  @Column(nullable = false)
  String resumo;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public LocalDate getDataInicial() {
    return dataInicial;
  }

  public void setDataInicial(LocalDate dataInicial) {
    this.dataInicial = dataInicial;
  }

  public LocalDate getDataFinal() {
    return dataFinal;
  }

  public void setDataFinal(LocalDate dataFinal) {
    this.dataFinal = dataFinal;
  }

  public LocalTime getHorarioInicial() {
    return horarioInicial;
  }

  public void setHorarioInicial(LocalTime horarioInicial) {
    this.horarioInicial = horarioInicial;
  }

  public LocalTime getHorarioFinal() {
    return horarioFinal;
  }

  public void setHorarioFinal(LocalTime horarioFinal) {
    this.horarioFinal = horarioFinal;
  }

  public Professor getProfessor() {
    return professor;
  }

  public void setProfessor(Professor professor) {
    this.professor = professor;
  }

  public Curso getCurso() {
    return curso;
  }

  public void setCurso(Curso curso) {
    this.curso = curso;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getResumo() {
    return resumo;
  }

  public void setResumo(String resumo) {
    this.resumo = resumo;
  }
}