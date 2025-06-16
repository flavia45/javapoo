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

    public Map<String,Object> puxarCliente(int id_cliente){
        return cdao.puxarCliente(id_cliente);
    }

    public void atualizarCliente(Cliente cli,int id_cliente){
        cdao.atualizarCliente(cli,id_cliente);
    }

    public void deletar(int id_cliente){
        cdao.deletar(id_cliente);
    }

}
