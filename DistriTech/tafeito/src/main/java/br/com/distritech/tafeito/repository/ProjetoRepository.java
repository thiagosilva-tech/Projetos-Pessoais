package br.com.distritech.tafeito.repository;

import br.com.distritech.tafeito.model.Projeto;
import br.com.distritech.tafeito.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
