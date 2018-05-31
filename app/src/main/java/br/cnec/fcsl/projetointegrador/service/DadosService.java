package br.cnec.fcsl.projetointegrador.service;

import br.cnec.fcsl.projetointegrador.service.dto.DadosResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DadosService {
    public static final String URL_BASE = "https://dadosabertos.camara.leg.br/api/v2/";

    @GET("deputados?pagina=1&itens=15")
    Call<DadosResponse> listarDeputados();

}
