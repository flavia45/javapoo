

package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class CursoService {
@Autowired 
    CursoDAO cdao;

    public void inserircurso(Curso cur){
        cdao.inserirCurso(cur);
    }

    public List<Map<String,Object>> puxarTodosCurso(){
        return cdao.puxarTodoscursos();
    }

    public Map<String,Object> puxarcurso(int id_curso){
        return cdao.puxarCurso(id_curso);
    }

    public void atualizarcurso(Curso pro,int id_curso){
        cdao.atualizarcurso(pro,id_curso);
    }

    public void deletar(int id_curso){
        cdao.deletar(id_curso);
    }
}
