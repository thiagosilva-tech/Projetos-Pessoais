package br.com.distritech.tafeito.repository;

import br.com.distritech.tafeito.model.Tarefa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	@Query("SELECT t FROM Tarefa t JOIN t.projeto p WHERE p.id = :projetoId")
	List<Tarefa> findByProjetoId(@Param("projetoId") Long projetoId);
}
