package br.cnec.fcsl.projetointegrador.service;

import br.cnec.fcsl.projetointegrador.service.dto.DeputadoIdResponse;
import br.cnec.fcsl.projetointegrador.service.dto.DeputadoResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DeputadoService {
    public static final String URL_BASE = "https://dadosabertos.camara.leg.br/api/v2/";

    @GET("deputados")
    Call<DeputadoResponse> listarDeputados(@Query("pagina")int pagina , @Query("itens")int itens);

    @GET("deputados/{id}")
    Call<DeputadoIdResponse> listarDeputados(@Path("id") Long id);

}
