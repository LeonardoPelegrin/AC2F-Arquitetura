package com.example.ac2f.repositories;

import com.example.ac2f.models.Agenda;
import com.example.ac2f.models.Professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    // verifica data (disponibilidade) do professor

    @Query("select a from Agenda a where a.dataInicial <= :data and a.dataFinal >= :data and a.professor.id = :id")
    List<Agenda> agendasProfessorPorData(@Param("id") Long id,
            @Param("data") LocalDate data);

    Optional<Professor> findByDataInicialBeforeEqual(LocalTime localtime);

}