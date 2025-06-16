package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ClienteDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

    public void inserirCliente(Cliente cli){
        String sql = "INSERT INTO cliente(nome, cpf) VALUES(?,?)";
        Object[] parametros = new Object[2];
        parametros[0] = cli.getNome();
        parametros[1] = cli.getCpf();
        jdbc.update(sql, parametros);
    }

    public List<Map<String,Object>> puxarTodosClientes(){
        String sql = "SELECT * FROM cliente;";
        return jdbc.queryForList(sql);
    } 

    public Map<String,Object> puxarCliente(int id_cliente){
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?;";
        return jdbc.queryForMap(sql, id_cliente);
    }

    public void deletar(int id_cliente){
        String sql = "DELETE FROM cliente where id_cliente = ?;";
        jdbc.update(sql, id_cliente);
    }

    public void atualizarCliente(Cliente cli, int id_cliente){
        String sql = "UPDATE cliente SET nome = ?, cpf = ? WHERE id_cliente = ?";
        Object[] parametros = new Object[3];
        parametros[0] = cli.getNome();
        parametros[1] = cli.getCpf();
        parametros[2] = id_cliente;
        jdbc.update(sql, parametros);
    }
}
