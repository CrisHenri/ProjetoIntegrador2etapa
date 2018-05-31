package br.cnec.fcsl.projetointegrador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.cnec.fcsl.projetointegrador.adapter.DadosAdapter;
import br.cnec.fcsl.projetointegrador.entidade.Dados;
import br.cnec.fcsl.projetointegrador.service.DadosService;
import br.cnec.fcsl.projetointegrador.service.dto.DadosResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity {
    private List<Dados> dados;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = findViewById(R.id.listDeputados);

        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarListaRest();
    }

    private void carregarListaRest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DadosService.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DadosService dadosService = retrofit.create(DadosService.class);
        Call<DadosResponse> request = dadosService.listarDeputados();
        request.enqueue(new Callback<DadosResponse>() {
            @Override
            public void onResponse(Call<DadosResponse> call, Response<DadosResponse> response) {
                if (response.isSuccessful()) {
                    DadosResponse resp = response.body();
                    dados = resp.getDados();
                    DadosAdapter adapter = new DadosAdapter(ListActivity.this, dados);
                    listView.setAdapter(adapter);
                } else if (response.code() == 400) {
                    Toast.makeText(ListActivity.this, "Erro Cliente", Toast.LENGTH_SHORT).show();
                } else if (response.code() == 500) {
                    Toast.makeText(ListActivity.this, "Erro Servidor", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DadosResponse> call, Throwable t) {
                Log.e("service", "Erro: " + t.getMessage());
            }
        });
    }
}
