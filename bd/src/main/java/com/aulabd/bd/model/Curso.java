package com.aulabd.bd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Curso {
    private int id_curso, id_cliente, id_professor;
    private String nome;

    //INICIALIZAR FORM
    public Curso(){
    }
    
    public Curso(int id_cliente, int id_professor, String nome){
        this.nome = nome;
        this.id_cliente = id_cliente;
        this.id_professor = id_professor;
    }

    public Curso(int id_curso, int id_cliente, int id_professor, String nome) {
        this.id_curso = id_curso;
        this.nome = nome;
        this.id_cliente = id_cliente;
        this.id_professor = id_professor;
    }

    public int getId_Curso() {
        return id_curso;
    }

    public String getNome() {
        return nome;
    }

    public int getId_Cliente() {
        return id_cliente;
    }

    public int getId_Professor() {
        return id_professor;
    }

    public void setId_Curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int setId_Cliente() {
        return id_cliente;
    }

    public int setId_Professor() {
        return id_professor;
    }

    public static Curso converterUmcurso (Map<String,Object> registro){
        int id_curso = (Integer) registro.get("id_curso");
        String nome = (String) registro.get("nome");
        int id_cliente = (Integer) registro.get("id_cliente");
        int id_professor = (Integer) registro.get("id_professor");
     
        Curso cur = new Curso(id_curso,id_cliente,id_professor,nome);
        return cur;
    }

    public static List<Curso> converterNcursos(List<Map<String,Object>> registros){
        List<Curso> aux = new ArrayList<Curso>();
        for(Map<String,Object> reg : registros){
            aux.add(converterUmcurso(reg));
        }
        return aux;
    }
}
