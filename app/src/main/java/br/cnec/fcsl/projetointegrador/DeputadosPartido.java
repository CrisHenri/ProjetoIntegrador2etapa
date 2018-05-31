package br.cnec.fcsl.projetointegrador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class DeputadosPartido extends AppCompatActivity {

    private String[] exemploDeputados= {"Deltrano", "Fulano", "Ciclano", "Beltrano"};
    private ListView listViewDeputadosDeUmPartido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deputados_partido);

        listViewDeputadosDeUmPartido= findViewById(R.id.listViewDeputadosPartido);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exemploDeputados);
        listViewDeputadosDeUmPartido.setAdapter(adapter);

    }
}
