package br.cnec.fcsl.projetointegrador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.cnec.fcsl.projetointegrador.entidade.Dados;

public class InfoDeputadoActivity extends AppCompatActivity {

    Dados dado;
    private TextView nome;
    private TextView partido;
    private TextView uf;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_deputado);

        nome = findViewById(R.id.txtNome);
        partido = findViewById(R.id.txtPartido);
        uf = findViewById(R.id.txtUf);
        img = findViewById(R.id.imgDeputado);

        dado = (Dados)getIntent().getSerializableExtra("dado");

        nome.setText(dado.getNome());
        partido.setText(dado.getSiglaPartido());
        uf.setText(dado.getSiglaUf());
        Picasso.get().load(dado.getUrlFoto()).into(img);
    }
}
