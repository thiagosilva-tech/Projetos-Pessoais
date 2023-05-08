package br.com.distritech.tafeito.controller;

import br.com.distritech.tafeito.model.Projeto;
import br.com.distritech.tafeito.model.Tarefa;
import br.com.distritech.tafeito.repository.ProjetoRepository;
import br.com.distritech.tafeito.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @GetMapping
    public String home(Model model){
        List<Tarefa> tarefas = tarefaRepository.findAll();
        model.addAttribute("tarefas", tarefas);
        List<Projeto> projetos = projetoRepository.findAll();
        model.addAttribute("projetos", projetos);
        return "home";
    }
    
    @GetMapping("/projeto/{id}")
    public String tarefaPorProjeto(@PathVariable("id") Long id, Model model) {
    	List<Tarefa> tarefas = tarefaRepository.findByProjetoId(id);
    	model.addAttribute("tarefas", tarefas);
    	List<Projeto> projetos = projetoRepository.findAll();
        model.addAttribute("projetos", projetos);
    	return "home";
    }
}
