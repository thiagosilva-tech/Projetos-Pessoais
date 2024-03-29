package br.com.distritech.tafeito.dto;

import br.com.distritech.tafeito.model.Projeto;
import jakarta.validation.constraints.NotBlank;

public class RequisicaoNovoProjeto {

    @NotBlank
    private String nomeProjeto;

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public Projeto toProjeto() {
        Projeto projeto = new Projeto();
        projeto.setNomeProjeto(nomeProjeto);
        return projeto;
    }
}
