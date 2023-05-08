package br.com.distritech.tafeito.controller;

import br.com.distritech.tafeito.dto.RequisicaoNovoProjeto;
import br.com.distritech.tafeito.model.Projeto;
import br.com.distritech.tafeito.model.Tarefa;
import br.com.distritech.tafeito.repository.ProjetoRepository;
import br.com.distritech.tafeito.repository.TarefaRepository;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("projeto")
public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoProjeto requisicao){

        return "/projeto/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoProjeto requisicao, BindingResult result){

        if(result.hasErrors()){
            return "/projeto/formulario";
        }
        Projeto projeto = requisicao.toProjeto();
        projetoRepository.save(projeto);
        return "redirect:/home";
    }
    
}
