package com.example.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {


    ArrayList<Pokemon> pokemonArrayList;
    Context context;

    LayoutInflater layoutInflater;

    public ListViewAdapter(ArrayList<Pokemon> pokemonArrayList, Context context) {
        this.pokemonArrayList = pokemonArrayList;
        this.context = context;
    }

    public ListViewAdapter(){}

    @Override
    public int getCount() {
        return pokemonArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return pokemonArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (layoutInflater == null)
        {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.customlayout,parent,false);
        }

        ImageView pokemonImage = convertView.findViewById(R.id.imgv_p);
        TextView pokemonName = convertView.findViewById(R.id.txtv_p);


        Picasso.get().load(pokemonArrayList.get(position).getImage()).into(pokemonImage);
        pokemonName.setText(pokemonArrayList.get(position).getName());


        return convertView;
    }
}
