package br.cnec.fcsl.projetointegrador.service.dto;

import java.util.List;

import br.cnec.fcsl.projetointegrador.entidade.Deputado;

public class DeputadoResponse {

    private List<Deputado> dados;

    public List<Deputado> getDados(){
        return dados;
    }

    public void setDados(List<Deputado> dados){
        this.dados = dados;
    }
}
