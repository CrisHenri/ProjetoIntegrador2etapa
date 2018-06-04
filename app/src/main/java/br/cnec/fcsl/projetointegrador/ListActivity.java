package br.cnec.fcsl.projetointegrador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.cnec.fcsl.projetointegrador.entidade.Deputado;
import br.cnec.fcsl.projetointegrador.adapter.DeputadoAdapter;
import br.cnec.fcsl.projetointegrador.entidade.Partido;
import br.cnec.fcsl.projetointegrador.service.DeputadoService;
import br.cnec.fcsl.projetointegrador.service.PartidoService;
import br.cnec.fcsl.projetointegrador.service.dto.DeputadoResponse;
import br.cnec.fcsl.projetointegrador.service.dto.PartidoIdResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity {
    private List<Deputado> deputados;
    private List<Partido> partidos;
    private ListView listView;
    private Deputado deputado;
    private int pagina = 1;
    private int itens = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = findViewById(R.id.listDeputados);

        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                deputado = deputados.get(position);
                Intent intentInfo = new Intent(ListActivity.this, InfoDeputadoActivity.class);
                intentInfo.putExtra("deputado", deputado);
                startActivity(intentInfo);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarListaRest(pagina,itens);
    }

    private Retrofit retrofit(String url){
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void carregarListaRest(int pagina, int itens) {
        DeputadoService dadosService = retrofit(DeputadoService.URL_BASE).create(DeputadoService.class);
        Call<DeputadoResponse> request = dadosService.listarDeputados(pagina, itens);
        request.enqueue(new Callback<DeputadoResponse>() {
            @Override
            public void onResponse(Call<DeputadoResponse> call, Response<DeputadoResponse> response) {
                if (response.isSuccessful()) {
                    DeputadoResponse resp = response.body();
                    deputados = resp.getDados();
                    DeputadoAdapter adapter = new DeputadoAdapter(ListActivity.this, deputados);
                    listView.setAdapter(adapter);
                } else if (response.code() == 400) {
                    Toast.makeText(ListActivity.this, "Erro Cliente", Toast.LENGTH_SHORT).show();
                } else if (response.code() == 500) {
                    Toast.makeText(ListActivity.this, "Erro Servidor", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DeputadoResponse> call, Throwable t) {
                Log.e("service", "Erro: " + t.getMessage());
            }
        });
    }

    public void next(View view) {
        pagina++;
        itens += 100;
        if(pagina <= 6){
           carregarListaRest(pagina, itens);
        }
    }

    public void previous(View view) {
        pagina--;
        itens -= 100;
        if(pagina >= 1){
            carregarListaRest(pagina, itens);
        }
    }
}
