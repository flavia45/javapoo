

package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.annotation.PostConstruct;


public class CursoDAO {
@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

    public void inserirCurso(Curso cur){
        String sql = "INSERT INTO curso(nome, id_cliente, id_professor) VALUES(?,?,?)";
        Object[] parametros = new Object[2];
        parametros[0] = cur.getNome();
        parametros[1] = cur.getId_Cliente();
        parametros[2] = cur.getId_Professor();
        jdbc.update(sql, parametros);
    }

    public List<Map<String,Object>> puxarTodoscursos(){
        String sql = "SELECT * FROM curso;";
        return jdbc.queryForList(sql);
    } 

    public Map<String,Object> puxarCurso(int id_curso){
        String sql = "SELECT * FROM curso WHERE id_curso = ?;";
        return jdbc.queryForMap(sql, id_curso);
    }

    public void deletar(int id_curso){
        String sql = "DELETE FROM curso where id_curso = ?;";
        jdbc.update(sql, id_curso);
    }

    public void atualizarcurso(Curso cur, int id_curso){
        String sql = "UPDATE curso SET nome = ?, id_cliente = ?, id_professor = ? WHERE id_curso = ?";
        Object[] parametros = new Object[3];
        parametros[0] = cur.getNome();
        parametros[1] = cur.getId_Cliente();
        parametros[2] = cur.getId_Professor();
        parametros[3] = id_curso;
        jdbc.update(sql, parametros);
    }
}
