package br.com.cristiana.carangoapp.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.cristiana.carangoapp.fragments.CarrosFragment;

/**
 * Created by Cristiana on 19/11/2016.
 */

public class TabAdapter extends FragmentStatePagerAdapter {

    public static final int TOTAL_TABS = 2;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    //retorno do gragment que será exibido
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();

        //qual o fragment será invocado
        if(position == 0){
            bundle.putString("tipo", "classicos");
        }else {
            bundle.putString("tipo", "esportivos");
        }

        Fragment f = new CarrosFragment();
        f.setArguments(bundle);

        return f;
    }

    @Override
    public int getCount() {
        return TOTAL_TABS;
    }
}
