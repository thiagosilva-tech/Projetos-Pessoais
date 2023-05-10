package br.com.distritech.tafeito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.distritech.tafeito.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

	@Query("select p from Projeto p join p.user u where u.username = :username")
	List<Projeto> findAllByUsuario(@Param("username") String username);
}
