package br.cnec.fcsl.projetointegrador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaDeTodosDeputados extends AppCompatActivity {

    private String[] exemploTodosDeputas= {"Fulano", "Ciclano", "Beltrano", "Ercilei", "Rendolvaldo"};
    private ListView listViewTodosDeputados1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_todos_deputados);

        listViewTodosDeputados1 = findViewById(R.id.listViewTodosDeputados);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exemploTodosDeputas);
        listViewTodosDeputados1.setAdapter(adapter);
    }
}
