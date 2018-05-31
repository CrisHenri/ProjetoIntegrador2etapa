package br.cnec.fcsl.projetointegrador.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.cnec.fcsl.projetointegrador.R;
import br.cnec.fcsl.projetointegrador.entidade.Dados;

public class DadosAdapter extends BaseAdapter {
    private List<Dados> dados;
    private Context context;

    public DadosAdapter(Context context, List<Dados> dados) {
        this.context = context;
        this.dados = dados;
    }

    @Override
    public int getCount() {
        return dados.size();
    }

    @Override
    public Object getItem(int position) {
        return dados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dados.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Dados deputado = dados.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        view = inflater.inflate(R.layout.list_item, null);

        TextView txtNome = view.findViewById(R.id.txtNome);
        TextView txtPartido = view.findViewById(R.id.txtPartido);
        ImageView imageView = view.findViewById(R.id.imageView);

        txtNome.setText(deputado.getNome());
        txtPartido.setText(deputado.getSiglaPartido());

        //usando biblioteca picasso
        Picasso.get().load(deputado.getUrlFoto()).into(imageView);

        return view;
    }
}
