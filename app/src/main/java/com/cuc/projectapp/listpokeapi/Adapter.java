package com.cuc.projectapp.listpokeapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends BaseAdapter {

    public Context context;
    public List<Pokemon> lst;

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView pokemonImage;
        TextView textNombrePokemon;
        TextView textFromPokemon;

        Pokemon p = lst.get(i);

        if (view ==null)
            view = LayoutInflater.from(context).inflate(R.layout.listview_pokemon,null);

        pokemonImage=view.findViewById(R.id.pokemonImage);
        textNombrePokemon=view.findViewById(R.id.textNombrePokemon);
        textFromPokemon=view.findViewById(R.id.textFromPokemon);

        pokemonImage.setImageResource(p.pokemon_image);
        textNombrePokemon.setText(p.pokemon_name);
        textFromPokemon.setText(p.from);


        return view;
    }


    public Adapter(Context context, List<Pokemon> lst) {
        this.context = context;
        this.lst = lst;
    }


}
