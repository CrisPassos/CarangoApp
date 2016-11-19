package br.com.cristiana.carangoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import br.com.cristiana.carangoapp.model.Carro;

public class DetalheActivity extends AppCompatActivity {
    private TextView tvDesc;
    private ImageView ivCarro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        tvDesc = (TextView) findViewById(R.id.tvDescD);
        ivCarro = (ImageView) findViewById(R.id.ivCarroD);

        if (getIntent() != null){
            Carro carro = getIntent().getParcelableExtra("carro");

            tvDesc.setText(carro.getDescricao());
            Picasso.with(this)
                    .load(carro.getFoto())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(ivCarro);


            Toast.makeText(this, carro.getNome(), Toast.LENGTH_SHORT).show();
        }
    }
}
