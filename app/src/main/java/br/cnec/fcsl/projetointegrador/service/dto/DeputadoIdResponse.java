package br.cnec.fcsl.projetointegrador.service.dto;

import java.util.List;

import br.cnec.fcsl.projetointegrador.entidade.Deputado;
import br.cnec.fcsl.projetointegrador.entidade.InfoDeputado;

public class DeputadoIdResponse {
    private InfoDeputado dados;

    public InfoDeputado getDados(){
        return dados;
    }

    public void setDados(InfoDeputado dados){
        this.dados = dados;
    }
}
