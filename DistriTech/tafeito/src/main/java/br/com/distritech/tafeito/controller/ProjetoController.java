package br.com.distritech.tafeito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.distritech.tafeito.dto.RequisicaoNovoProjeto;
import br.com.distritech.tafeito.model.Projeto;
import br.com.distritech.tafeito.model.User;
import br.com.distritech.tafeito.repository.ProjetoRepository;
import br.com.distritech.tafeito.repository.UserRepository;

@Controller
@RequestMapping("projeto")
public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoProjeto requisicao){

        return "/projeto/formulario";
    }

    @PostMapping("novo")
    public String novo(@Validated RequisicaoNovoProjeto requisicao, BindingResult result){

        if(result.hasErrors()){
            return "/projeto/formulario";
        }
        
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        
        Projeto projeto = requisicao.toProjeto();
        projeto.setUser(user);
        projetoRepository.save(projeto);
        return "redirect:/home";
    }
    
}
