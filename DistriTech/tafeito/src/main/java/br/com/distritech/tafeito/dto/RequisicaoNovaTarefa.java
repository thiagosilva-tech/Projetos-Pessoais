package br.com.distritech.tafeito.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import br.com.distritech.tafeito.model.StatusTarefa;
import br.com.distritech.tafeito.model.Tarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Validated
public class RequisicaoNovaTarefa {

    @NotBlank
    private String nomeTarefa;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataConclusaoTarefa;

    @NotBlank
    private String descricaoTarefa;

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public LocalDate getDataConclusaoTarefa() {
        return dataConclusaoTarefa;
    }

    public void setDataConclusaoTarefa(LocalDate dataConclusaoTarefa) {
        this.dataConclusaoTarefa = dataConclusaoTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public Tarefa toTarefa() {
        Tarefa tarefa = new Tarefa();
        tarefa.setNomeTarefa(nomeTarefa);
        tarefa.setDataConclusaoTarefa(dataConclusaoTarefa);
        tarefa.setDescricaoTarefa(descricaoTarefa);


        if (dataConclusaoTarefa.isBefore(tarefa.getDataCriacaoTarefa())){
            tarefa.setStatus(StatusTarefa.ATRASADO);
        } else {
            tarefa.setStatus(StatusTarefa.EMDIA);
        }
        return tarefa;
    }
}
