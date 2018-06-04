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
import br.cnec.fcsl.projetointegrador.entidade.Deputado;

public class DeputadoAdapter extends BaseAdapter {
    private List<Deputado> deputados;
    private Context context;

    public DeputadoAdapter(Context context, List<Deputado> deputados) {
        this.context = context;
        this.deputados = deputados;
    }

    @Override
    public int getCount() {
        return deputados.size();
    }

    @Override
    public Object getItem(int position) {
        return deputados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return deputados.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Deputado deputado = deputados.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        view = inflater.inflate(R.layout.list_item, null);

        TextView txtNome = view.findViewById(R.id.txt);
        TextView txtPartido = view.findViewById(R.id.txtPartido);
        TextView txtUf = view.findViewById(R.id.txtUf);
        ImageView imageView = view.findViewById(R.id.imageView);

        txtNome.setText(deputado.getNome());
        txtPartido.setText(deputado.getSiglaPartido());
        txtUf.setText(deputado.getSiglaUf());

        //usando biblioteca picasso
        Picasso.get().load(deputado.getUrlFoto()).into(imageView);

        return view;
    }
}
