package br.cnec.fcsl.projetointegrador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaDePartidos extends AppCompatActivity {

    private String[] exemploPartidos= {"PMDB", "PT", "PSOL", "PSDB", "PSL"};
    private ListView listViewPartidos1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_partidos);

        listViewPartidos1 = findViewById(R.id.listViewPartidos);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exemploPartidos);
        listViewPartidos1.setAdapter(adapter);
    }
}
