package br.cnec.fcsl.projetointegrador.service.dto;

import java.util.List;

import br.cnec.fcsl.projetointegrador.entidade.Dados;

public class DadosResponse {
    private List<Dados> dados;

    public List<Dados> getDados(){
        return dados;
    }

    public void setDados(List<Dados> dados){
        this.dados = dados;
    }
}
