package br.cnec.fcsl.projetointegrador.service.dto;

import br.cnec.fcsl.projetointegrador.entidade.InfoDeputado;

public class InfoDeputadoResponse {

    private InfoDeputado dados;

    public InfoDeputado getDados(){
        return dados;
    }

    public void setDados(InfoDeputado dados){
        this.dados = dados;
    }
}
