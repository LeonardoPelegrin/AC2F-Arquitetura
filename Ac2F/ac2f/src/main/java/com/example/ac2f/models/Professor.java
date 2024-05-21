package com.example.ac2f.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_professor")
public class Professor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private long id;
  
  @ManyToMany
  @JoinTable(name = "tb_professor_curso",
  joinColumns = @JoinColumn(name = "professor_id"),
  inverseJoinColumns = @JoinColumn(name = "curso_id"))
  @Column(nullable = false)
  List<Curso> cursos;

  @ManyToMany(mappedBy = "professor")
  List<Agenda> agendas;

  @Column(nullable = false)
  String nome;

  @Column(nullable = false)
  String cpf;

  @Column(nullable = false)
  String endereco;

  @Column(nullable = false)
  String telefone;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public List<Agenda> getAgendas() {
    return agendas;
  }

  public void setAgendas(List<Agenda> agendas) {
    this.agendas = agendas;
  }

  public List<Curso> getCursos() {
    return cursos;
  }

  public void setCursos(List<Curso> cursos) {
    this.cursos = cursos;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
}