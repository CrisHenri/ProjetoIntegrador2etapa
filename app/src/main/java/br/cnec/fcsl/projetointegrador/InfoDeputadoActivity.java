package br.cnec.fcsl.projetointegrador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.cnec.fcsl.projetointegrador.entidade.Deputado;
import br.cnec.fcsl.projetointegrador.entidade.InfoDeputado;
import br.cnec.fcsl.projetointegrador.entidade.Partido;
import br.cnec.fcsl.projetointegrador.service.DeputadoService;
import br.cnec.fcsl.projetointegrador.service.PartidoService;
import br.cnec.fcsl.projetointegrador.service.dto.DeputadoIdResponse;
import br.cnec.fcsl.projetointegrador.service.dto.DeputadoResponse;
import br.cnec.fcsl.projetointegrador.service.dto.PartidoIdResponse;
import br.cnec.fcsl.projetointegrador.service.dto.PartidoResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoDeputadoActivity extends AppCompatActivity {

    InfoDeputado infoDeputado;
    Deputado deputado;
    Partido partido;
    private List<Partido> partidos;
    private TextView nome;
    private TextView siglaPartido;
    private TextView uf;
    private ImageView img;
    private ImageView imgLogo;
    private TextView gabinete;
    private TextView predio;
    private TextView sala;
    private TextView andar;
    private TextView telefone;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_deputado);

        nome = findViewById(R.id.txtNome);
        siglaPartido = findViewById(R.id.txtPartido);
        uf = findViewById(R.id.txtUf);
        img = findViewById(R.id.imgDeputado);
        imgLogo = findViewById(R.id.imgLogo);
        gabinete = findViewById(R.id.txtGabinete);
        predio = findViewById(R.id.txtPredio);
        sala = findViewById(R.id.txtSala);
        andar = findViewById(R.id.txtAndar);
        telefone = findViewById(R.id.txtTelefone);
        email = findViewById(R.id.txtEmail);

        deputado = (Deputado) getIntent().getSerializableExtra("deputado");

        carregar(getIdPartido());
        carregarInfoDeputado(deputado.getId());

        nome.setText(deputado.getNome());
        siglaPartido.setText(deputado.getSiglaPartido());
        uf.setText(deputado.getSiglaUf());
        Picasso.get().load(deputado.getUrlFoto()).into(img);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private String getIdPartido(){
        String[] vet = deputado.getUriPartido().split("/");
        return vet[vet.length-1];
    }

    private Retrofit retrofit(String url){
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    private void carregar(String idPartido) {
        PartidoService partidoService = retrofit(PartidoService.URL_BASE).create(PartidoService.class);
        Call<PartidoIdResponse> request = partidoService.listarPartidos(idPartido);
        request.enqueue(new Callback<PartidoIdResponse>() {
            @Override
            public void onResponse(Call<PartidoIdResponse> call, Response<PartidoIdResponse> response) {
                if (response.isSuccessful()) {
                    PartidoIdResponse resp = response.body();
                    partido = resp.getDados();
                    Picasso.get().load(partido.getUrlLogo()).into(imgLogo);
                } else if (response.code() == 400) {
                    Toast.makeText(InfoDeputadoActivity.this, "Erro Cliente", Toast.LENGTH_SHORT).show();
                } else if (response.code() == 500) {
                    Toast.makeText(InfoDeputadoActivity.this, "Erro Servidor", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PartidoIdResponse> call, Throwable t) {
                Log.e("service", "Erro: " + t.getMessage());
            }
        });
    }

    private void carregarInfoDeputado(Long idDeputado) {
        DeputadoService deputadoService = retrofit(DeputadoService.URL_BASE).create(DeputadoService.class);
        Call<DeputadoIdResponse> request = deputadoService.listarDeputados(idDeputado);
        request.enqueue(new Callback<DeputadoIdResponse>() {
            @Override
            public void onResponse(Call<DeputadoIdResponse> call, Response<DeputadoIdResponse> response) {
                if (response.isSuccessful()) {
                    DeputadoIdResponse resp = response.body();
                    infoDeputado = resp.getDados();
                    gabinete.setText(infoDeputado.getUltimoStatus().getGabinete().getNome());
                    predio.setText(infoDeputado.getUltimoStatus().getGabinete().getPredio());
                    sala.setText(infoDeputado.getUltimoStatus().getGabinete().getSala());
                    andar.setText(infoDeputado.getUltimoStatus().getGabinete().getAndar());
                    telefone.setText(infoDeputado.getUltimoStatus().getGabinete().getTelefone());
                    email.setText(infoDeputado.getUltimoStatus().getGabinete().getEmail());
                } else if (response.code() == 400) {
                    Toast.makeText(InfoDeputadoActivity.this, "Erro Cliente", Toast.LENGTH_SHORT).show();
                } else if (response.code() == 500) {
                    Toast.makeText(InfoDeputadoActivity.this, "Erro Servidor", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DeputadoIdResponse> call, Throwable t) {
                Log.e("service", "Erro: " + t.getMessage());
            }
        });
    }
}
