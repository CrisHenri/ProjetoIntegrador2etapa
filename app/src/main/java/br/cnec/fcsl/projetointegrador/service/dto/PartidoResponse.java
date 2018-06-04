package br.cnec.fcsl.projetointegrador.service.dto;

import java.util.List;

import br.cnec.fcsl.projetointegrador.entidade.Partido;

public class PartidoResponse {

    private List<Partido> dados;

    public List<Partido> getDados(){
        return dados;
    }

    public void setDados(List<Partido> dados){
        this.dados = dados;
    }
}
