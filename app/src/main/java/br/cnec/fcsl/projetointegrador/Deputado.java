package br.cnec.fcsl.projetointegrador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.cnec.fcsl.projetointegrador.entidade.Dados;

public class Deputado extends AppCompatActivity {
    Dados dado;
    private TextView nome;
    private TextView sigla;
    private TextView idade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deputado);

        nome = findViewById(R.id.txtNomeCompleto);
        sigla = findViewById(R.id.txtSiglaPartido);

        dado = (Dados)getIntent().getSerializableExtra("dado");

        nome.setText(dado.getNome());
        sigla.setText(dado.getSiglaPartido());
    }
}
