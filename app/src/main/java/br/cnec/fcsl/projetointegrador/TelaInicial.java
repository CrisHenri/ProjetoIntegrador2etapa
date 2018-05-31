package br.cnec.fcsl.projetointegrador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }

    public void bucarCandidato(View v){

        Intent intentDeputado= new Intent(this ,Deputado.class);//objeto que recebe qual tela que será aberta
        startActivity(intentDeputado);//método para abrir uma nova view
    }

    public void buscarCandidatosDeUmPartido(View v){

        Intent intentDeputadosPartido= new Intent(this ,DeputadosPartido.class);
        startActivity(intentDeputadosPartido);
    }

    public void listarTodosDeputados(View v){

        Intent intentTodosDeputados= new Intent(this ,ListaDeTodosDeputados.class);
        startActivity(intentTodosDeputados);
    }

    public void listarTodosOsPartidos(View v){

        Intent intentTodosOsPartidos= new Intent(this ,ListaDePartidos.class);
        startActivity(intentTodosOsPartidos);
    }
}
