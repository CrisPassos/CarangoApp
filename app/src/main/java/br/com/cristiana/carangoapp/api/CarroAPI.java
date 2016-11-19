package br.com.cristiana.carangoapp.api;

import java.util.List;

import br.com.cristiana.carangoapp.model.Carro;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Cristiana on 19/11/2016.
 */

public interface CarroAPI {

    //tipo = esportivo ou classico
    @GET("/carros/tipo/{tipo}")
    Call<List<Carro>> findBy(@Path("tipo") String tipo);

}
