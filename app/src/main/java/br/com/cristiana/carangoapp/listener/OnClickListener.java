package br.com.cristiana.carangoapp.listener;

import android.view.View;

/**
 * Created by Cristiana on 19/11/2016.
 */

public interface OnClickListener {

    //Recupera a view e a posição em que foi clicado
    public void onClick(View v, int position);
}
