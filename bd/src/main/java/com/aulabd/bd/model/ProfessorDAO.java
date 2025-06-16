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

    public List<Map<String,Object>> puxarTodosProfessores(){
        String sql = "SELECT * FROM professor;";
        return jdbc.queryForList(sql);
    } 

    public Map<String,Object> puxarProfessor(int id_professor){
        String sql = "SELECT * FROM professor WHERE id_professor = ?;";
        return jdbc.queryForMap(sql, id_professor);
    }

    public void deletar(int id_professor){
        String sql = "DELETE FROM professor where id_professor = ?;";
        jdbc.update(sql, id_professor);
    }

    public void atualizarProfessor(Professor pro, int id_professor){
        String sql = "UPDATE professor SET nome = ?, cpf = ? WHERE id_professor = ?";
        Object[] parametros = new Object[3];
        parametros[0] = pro.getNome();
        parametros[1] = pro.getCpf();
        parametros[2] = id_professor;
        jdbc.update(sql, parametros);
    }
}
