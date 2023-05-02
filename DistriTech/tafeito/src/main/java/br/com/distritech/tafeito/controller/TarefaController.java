package br.com.distritech.tafeito.controller;

import br.com.distritech.tafeito.dto.RequisicaoEditarTarefa;
import br.com.distritech.tafeito.dto.RequisicaoNovaTarefa;
import br.com.distritech.tafeito.model.Tarefa;
import br.com.distritech.tafeito.repository.TarefaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String novo(@Valid RequisicaoNovaTarefa requisicao, BindingResult result){
        if(result.hasErrors()){
            return "tarefa/formulario";
        }
        Tarefa tarefa = requisicao.toTarefa();
        tarefaRepository.save(tarefa);
        return "redirect:/home";
    }

    @DeleteMapping("excluir/{id}")
    public String excluir(@PathVariable("id") Long id){
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        tarefaRepository.delete(tarefa);
        return "redirect:/home";
    }

    @GetMapping("editar/{id}")
    public String editarTarefa(@PathVariable("id") Long id, Model model){
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("tarefa", tarefa);
        return "tarefa/formularioEdicao";
    }

    @PostMapping("editar")
    public String editarTarefa(@ModelAttribute("tarefa") Tarefa tarefa, BindingResult result){
        if (result.hasErrors()){
            return "/tarefa/formularioEdicao";
        }
        Tarefa tarefaExistente = tarefaRepository.findById(tarefa.getId()).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + tarefa.getId()));
        tarefaExistente.setId(tarefa.getId());
        tarefaExistente.setNomeTarefa(tarefa.getNomeTarefa());
        tarefaExistente.setDescricaoTarefa(tarefa.getDescricaoTarefa());
        tarefaExistente.setDataConclusaoTarefa(tarefa.getDataConclusaoTarefa());

        System.out.println(tarefaExistente);
        tarefaRepository.save(tarefaExistente);
        return "redirect:/home";
    }
}
