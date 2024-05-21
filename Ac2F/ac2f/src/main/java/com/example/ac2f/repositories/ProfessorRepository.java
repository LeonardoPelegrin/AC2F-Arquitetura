package com.example.ac2f.repositories;

import com.example.ac2f.models.Agenda;
import com.example.ac2f.models.Professor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    // professor que detem a especialização do curso
    @Query("select a from Agenda a where a.professor.id = :id")
    List<Agenda> agendasDoProfessor(@Param("id") Long id);

}



