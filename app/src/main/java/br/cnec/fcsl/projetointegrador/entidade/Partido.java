package br.cnec.fcsl.projetointegrador.entidade;

import java.io.Serializable;

public class Partido implements Serializable {

    private Long id;
    private String sigla;
    private String nome;
    private String uri;
   // private String status;
    private Long numeroEleitoral;
    private String urlLogo;
    private String urlWebSite;
    private String urlFacebook;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

   // public String getStatus() {
  //      return status;
   // }

    //public void setStatus(String status) {
     //   this.status = status;
   // }

    public Long getNumeroEleitoral() {
        return numeroEleitoral;
    }

    public void setNumeroEleitoral(Long numeroEleitoral) {
        this.numeroEleitoral = numeroEleitoral;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getUrlWebSite() {
        return urlWebSite;
    }

    public void setUrlWebSite(String urlWebSite) {
        this.urlWebSite = urlWebSite;
    }

    public String getUrlFacebook() {
        return urlFacebook;
    }

    public void setUrlFacebook(String urlFacebook) {
        this.urlFacebook = urlFacebook;
    }
}
