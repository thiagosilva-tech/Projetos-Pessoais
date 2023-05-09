package br.com.distritech.tafeito.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Projeto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "projeto")
    private List<Tarefa> tarefas;

    private String nomeProjeto;

    public Long getId() {
		return id;
	}
    
    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public void addTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
        tarefa.setProjeto(this);
    }

    public void removeTarefa(Tarefa tarefa){
        tarefas.remove(tarefa);
        tarefa.setProjeto(null);
    }
}
