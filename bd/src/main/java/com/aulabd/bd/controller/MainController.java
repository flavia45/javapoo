package com.aulabd.bd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aulabd.bd.model.Cliente;
import com.aulabd.bd.model.ClienteService;
import com.aulabd.bd.model.Professor;
import com.aulabd.bd.model.ProfessorService;

@Controller
public class MainController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/sucesso")
    public String sucesso() {
        return "sucesso";
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("nomePag", "CADASTRO DE CLIENTES");
        model.addAttribute("valorBtn", "Cadastrar");
        model.addAttribute("link", "/cadastro");
        return "cadastro";
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable int id) {
        ClienteService cs = context.getBean(ClienteService.class);
        Map<String, Object> reg = cs.puxarCliente(id);
        Cliente cli = Cliente.converterUmCliente(reg);
        model.addAttribute("cliente", cli);
        model.addAttribute("link", "/editar/" + id);
        model.addAttribute("nomePag", "EDITAR CLIENTES");
        model.addAttribute("valorBtn", "Atualizar");
        return "cadastro";
    }

    @PostMapping("/editar/{id}")
    public String editar(@ModelAttribute Cliente cli,
            @PathVariable int id) {
        ClienteService cs = context.getBean(ClienteService.class);
        cs.atualizarCliente(cli, id);
        return "redirect:/listar";
    }

    @PostMapping("/cadastro")
    public String cadastro(Model model, @ModelAttribute Cliente cli) {
        // PARA CADA TABELA, 1 SERVICE e 1 DAO, ALEM DE 1 POJO
        ClienteService cs = context.getBean(ClienteService.class);
        cs.inserirCliente(cli);
        return "redirect:listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        ClienteService cs = context.getBean(ClienteService.class);
        List<Map<String, Object>> lr = cs.puxarTodosClientes();
        List<Cliente> lc = Cliente.converterNClientes(lr);
        model.addAttribute("clientes", lc);
        return "lista";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        ClienteService cs = context.getBean(ClienteService.class);
        cs.deletar(id);
        return "redirect:/listar";
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("professor", new Professor());
        model.addAttribute("nomePag", "CADASTRO DE PROFESSOR");
        model.addAttribute("valorBtn", "Cadastrar");
        model.addAttribute("link", "/cadastro");
        return "cadastro";
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable int id_professor) {
        ProfessorService cs = context.getBean(ProfessorService.class);
        Map<String, Object> reg = cs.puxarProfessor(id_professor);
        Professor pro = Professor.converterUmProfessor(reg);
        model.addAttribute("professor", pro);
        model.addAttribute("link", "/editar/" + id_professor);
        model.addAttribute("nomePag", "EDITAR PROFESSOR");
        model.addAttribute("valorBtn", "Atualizar");
        return "cadastro";
    }

    @PostMapping("/editar/{id}")
    public String editar(@ModelAttribute Professor pro,
            @PathVariable int id_professor) {
        ProfessorService cs = context.getBean(ProfessorService.class);
        cs.atualizarProfessor(pro, id_professor);
        return "redirect:/listar";
    }

    @PostMapping("/cadastro")
    public String cadastro(Model model, @ModelAttribute Professor pro) {

        ProfessorService cs = context.getBean(ProfessoService.class);
        cs.inserirProfessor(pro);
        return "redirect:listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        ProfessorService cs = context.getBean(ProfesorService.class);
        List<Map<String, Object>> lr = cs.puxarTodosProfessores();
        List<Professor> lc = P.converterNClientes(lr);
        model.addAttribute("Professor", lc);
        return "lista";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        ProfessorService cs = context.getBean(ProfessorService.class);
        cs.deletar(id_professor);
        return "redirect:/listar";
    }
}
