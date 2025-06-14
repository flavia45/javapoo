
package com.aulabd.bd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Professor {
private int id;
    private String nome, cpf;

    //INICIALIZAR FORM
    public Professor(){

    }

    //id eh auto incremento, INSERIR
    public Professor(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    //SELECT
    public Professor(int id, String cpf, String nome) {
        this.cpf = cpf;
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static Professor converterUmProfessor (Map<String,Object> registro){
        int id = (Integer) registro.get("id");
        String nome = (String) registro.get("nome");
        String cpf = (String) registro.get("cpf");
        Professor cli = new Professor(id,cpf,nome);
        return cli;
    }

    public static List<Professor> converterNProfessors(List<Map<String,Object>> registros){
        List<Professor> aux = new ArrayList<Professor>();
        for(Map<String,Object> reg : registros){
            aux.add(converterUmProfessor(reg));
        }
        return aux;
    }
}

