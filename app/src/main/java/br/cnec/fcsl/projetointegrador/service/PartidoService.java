package br.cnec.fcsl.projetointegrador.service;

import br.cnec.fcsl.projetointegrador.service.dto.PartidoIdResponse;
import br.cnec.fcsl.projetointegrador.service.dto.PartidoResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PartidoService {

    public static final String URL_BASE = "https://dadosabertos.camara.leg.br/api/v2/";

    @GET("partidos/{id}")
    Call<PartidoIdResponse> listarPartidos(@Path("id") String id);

}
