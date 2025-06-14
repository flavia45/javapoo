

package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.annotation.PostConstruct;

public class ProfessorDAO {

    @Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

    public void inserirProfessor(Professor pro){
        String sql = "INSERT INTO professor(nome, cpf) VALUES(?,?)";
        Object[] parametros = new Object[2];
        parametros[0] = pro.getNome();
        parametros[1] = pro.getCpf();
        jdbc.update(sql, parametros);
    }

    public List<Map<String,Object>> puxarTodosProfessors(){
        String sql = "SELECT * FROM professor;";
        return jdbc.queryForList(sql);
    } 

    public Map<String,Object> puxarProfessor(int id){
        String sql = "SELECT * FROM professor WHERE id = ?;";
        return jdbc.queryForMap(sql, id);
    }

    public void deletar(int id){
        String sql = "DELETE FROM professor where id = ?;";
        jdbc.update(sql, id);
    }

    public void atualizarProfessor(Professor pro, int id){
        String sql = "UPDATE professor SET nome = ?, cpf = ? WHERE id = ?";
        Object[] parametros = new Object[3];
        parametros[0] = pro.getNome();
        parametros[1] = pro.getCpf();
        parametros[2] = id;
        jdbc.update(sql, parametros);
    }
}
