
package com.aulabd.bd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Professor {
private int id_professor;
    private String nome, cpf;

    //INICIALIZAR FORM
    public Professor(){
    }

    public Professor(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public Professor(int id_professor, String cpf, String nome) {
        this.cpf = cpf;
        this.id_professor = id_professor;
        this.nome = nome;
    }

    public int getId_professor() {
        return id_professor;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setId(int id_professor) {
        this.id_professor = id_professor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static Professor converterUmProfessor (Map<String,Object> registro){
        int id_professor = (Integer) registro.get("id_professor");
        String nome = (String) registro.get("nome");
        String cpf = (String) registro.get("cpf");
        Professor pro = new Professor(id_professor,cpf,nome);
        return pro;
    }

    public static List<Professor> converterNProfessors(List<Map<String,Object>> registros){
        List<Professor> aux = new ArrayList<Professor>();
        for(Map<String,Object> reg : registros){
            aux.add(converterUmProfessor(reg));
        }
        return aux;
    }
}

