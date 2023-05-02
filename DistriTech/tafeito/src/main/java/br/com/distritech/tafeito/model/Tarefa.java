package br.com.distritech.tafeito.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Tarefa{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    private String nomeTarefa;
    private String descricaoTarefa;
    private LocalDate dataCriacaoTarefa = LocalDate.now();
    private LocalDate dataConclusaoTarefa;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    public Long getId() {
        return id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public LocalDate getDataCriacaoTarefa() {
        return dataCriacaoTarefa;
    }

    public void setDataCriacaoTarefa(LocalDate dataCriacaoTarefa) {
        this.dataCriacaoTarefa = dataCriacaoTarefa;
    }

    public LocalDate getDataConclusaoTarefa() {
        return dataConclusaoTarefa;
    }

    public void setDataConclusaoTarefa(LocalDate dataConclusaoTarefa) {
        this.dataConclusaoTarefa = dataConclusaoTarefa;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public Projeto getProjeto(){
        return projeto;
    }

    public void setProjeto(Projeto projeto){
        this.projeto = projeto;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
