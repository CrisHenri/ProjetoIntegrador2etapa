package br.cnec.fcsl.projetointegrador.service.dto;

import br.cnec.fcsl.projetointegrador.entidade.Partido;

public class PartidoIdResponse {
    private Partido dados;

    public Partido getDados(){
        return dados;
    }

    public void setDados(Partido dados){
        this.dados = dados;
    }
}
