package com.example.ac2f.repositories;

import com.example.ac2f.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("select c from Curso c left join fetch c.professores p where c.id = :id ")
    Optional<Curso> findCursoProfessorFetchCursos(@Param("id") Long id);

}
 