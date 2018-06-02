package br.cnec.fcsl.projetointegrador.service;

import br.cnec.fcsl.projetointegrador.service.dto.DadosResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DadosService {
    public static final String URL_BASE = "https://dadosabertos.camara.leg.br/api/v2/";

    @GET("deputados")
    Call<DadosResponse> listarDeputados(@Query("pagina")int pagina);

}
