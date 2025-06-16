
package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class ProfessorService {
    @Autowired 
    ProfessorDAO cdao;

    public void inserirProfessor(Professor pro){
        cdao.inserirProfessor(pro);
    }
    public List<Map<String,Object>> puxarTodosProfessores(){
        return cdao.puxarTodosProfessores();
    }

    public Map<String,Object> puxarProfessor(int id_professor){
        return cdao.puxarProfessor(id_professor);
    }

    public void atualizarProfessor(Professor pro,int id_professor){
        cdao.atualizarProfessor(pro,id_professor);
    }

    public void deletar(int id_professor){
        cdao.deletar(id_professor);
    }
}
