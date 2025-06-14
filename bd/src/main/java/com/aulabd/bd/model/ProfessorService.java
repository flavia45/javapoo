
package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class ProfessorService {
    @Autowired //cria a bagaca pra mim!
    ProfessorDAO cdao;

    public void inserirProfessor(Professor pro){
        cdao.inserirProfessor(pro);
    }

    public List<Map<String,Object>> puxarTodosProfessors(){
        return cdao.puxarTodosProfessors();
    }

    public Map<String,Object> puxarProfessor(int id){
        return cdao.puxarProfessor(id);
    }

    public void atualizarProfessor(Professor pro,int id){
        cdao.atualizarProfessor(pro,id);
    }

    public void deletar(int id){
        cdao.deletar(id);
    }
}
