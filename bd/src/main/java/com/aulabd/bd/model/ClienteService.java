package com.aulabd.bd.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired //cria a bagaca pra mim!
    ClienteDAO cdao;

    public void inserirCliente(Cliente cli){
        cdao.inserirCliente(cli);
    }

    public List<Map<String,Object>> puxarTodosClientes(){
        return cdao.puxarTodosClientes();
    }

    public Map<String,Object> puxarCliente(int id){
        return cdao.puxarCliente(id);
    }

    public void atualizarCliente(Cliente cli,int id){
        cdao.atualizarCliente(cli,id);
    }

    public void deletar(int id){
        cdao.deletar(id);
    }

}
