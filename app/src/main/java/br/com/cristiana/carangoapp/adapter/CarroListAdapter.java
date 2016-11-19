package br.com.cristiana.carangoapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.cristiana.carangoapp.R;
import br.com.cristiana.carangoapp.listener.OnClickListener;
import br.com.cristiana.carangoapp.model.Carro;

/**
 * Created by Cristiana on 19/11/2016.
 */

public class CarroListAdapter extends
        RecyclerView.Adapter<CarroListAdapter.CarrosViewHolder> {

    private Context context;
    private List<Carro> carros;
    private OnClickListener clickListener;

    public CarroListAdapter(Context context, List<Carro> carros, OnClickListener clickListener) {
        this.context = context;
        this.carros = carros;
        this.clickListener = clickListener;
    }

    @Override
    public CarrosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.carro_item, parent, false);

        return new CarrosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CarrosViewHolder holder, final int position) {
        holder.tvNome.setText(carros.get(position).getNome());
        holder.tvDescricao.setText(carros.get(position).getDescricao());
        //vai pesquisar a foto na internet e adiciona no imageview
        Picasso.with(context)
                .load(carros.get(position).getFoto())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivCarro);

        if (clickListener !=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onClick(holder.itemView, position);

                }
            });
        }
    }

    public Carro getItem(int position){
        return carros.get(position);
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarrosViewHolder extends RecyclerView.ViewHolder {
        TextView tvNome;
        TextView tvDescricao;
        ImageView ivCarro;

        public CarrosViewHolder(View itemView) {
            super(itemView);
            tvNome = (TextView) itemView.findViewById(R.id.tv_nome);
            tvDescricao = (TextView) itemView.findViewById(R.id.tv_desc);
            ivCarro = (ImageView) itemView.findViewById(R.id.ivCarro);
        }
    }
}
