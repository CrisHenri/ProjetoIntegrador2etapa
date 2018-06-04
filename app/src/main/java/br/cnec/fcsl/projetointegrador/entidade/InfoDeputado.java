package br.cnec.fcsl.projetointegrador.entidade;

import java.io.Serializable;
import java.util.List;

public class InfoDeputado implements Serializable {

    private Long id;
    private String uri;
    private String nomeCivil;
    private UltimoStatus ultimoStatus;
    private String cpf;
    private String sexo;
    private String urlWebsite;
    private List<String> redeSocial;
    private String dataNascimento;
    private String dataFalecimento;
    private String ufNascimento;
    private String municipioNascimento;
    private String escolaridade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getNomeCivil() {
        return nomeCivil;
    }

    public void setNomeCivil(String nomeCivil) {
        this.nomeCivil = nomeCivil;
    }

    public UltimoStatus getUltimoStatus() {
        return ultimoStatus;
    }

    public void setUltimoStatus(UltimoStatus ultimoStatus) {
        this.ultimoStatus = ultimoStatus;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUrlWebsite() {
        return urlWebsite;
    }

    public void setUrlWebsite(String urlWebsite) {
        this.urlWebsite = urlWebsite;
    }

    public List<String> getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(List<String> redeSocial) {
        this.redeSocial = redeSocial;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(String dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public String getUfNascimento() {
        return ufNascimento;
    }

    public void setUfNascimento(String ufNascimento) {
        this.ufNascimento = ufNascimento;
    }

    public String getMunicipioNascimento() {
        return municipioNascimento;
    }

    public void setMunicipioNascimento(String municipioNascimento) {
        this.municipioNascimento = municipioNascimento;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }
}
