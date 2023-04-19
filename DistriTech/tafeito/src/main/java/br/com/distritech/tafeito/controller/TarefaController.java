package br.com.distritech.tafeito.controller;

import br.com.distritech.tafeito.dto.RequisicaoNovaTarefa;
import br.com.distritech.tafeito.model.Tarefa;
import br.com.distritech.tafeito.repository.TarefaRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tarefa")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovaTarefa requisicao){

        return "tarefa/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovaTarefa requisicao, Errors result){
        if(result.hasErrors()){
            return "/tarefa/formulario";
        }
        Tarefa tarefa = requisicao.toTarefa();
        tarefaRepository.save(tarefa);
        return "/home";
    }
}
