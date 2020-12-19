package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Pokemondesc extends AppCompatActivity {

    ImageView pImage;
    TextView  pName,pType,pAbility,pHeight,pWeight,pDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemondesc);

        pImage = findViewById(R.id.desc_img);
        pName = findViewById(R.id.txt_name);
        pType = findViewById(R.id.txt_type);
        pAbility = findViewById(R.id.txt_ability);
        pHeight = findViewById(R.id.txt_height);
        pWeight = findViewById(R.id.txt_weight);
        pDesc = findViewById(R.id.txt_desc);


        Intent intent = getIntent();

        Pokemon pokemon = intent.getParcelableExtra("poke");


        Picasso.get().load(pokemon.getImage()).into(pImage);

        pName.setText(pokemon.getName());
        pType.setText(pokemon.getType());
        pAbility.setText(pokemon.getAbility());
        pHeight.setText(pokemon.getHeight());
        pWeight.setText(pokemon.getWeight());
        pDesc.setText(pokemon.getDescription());

        pDesc.setMovementMethod(new ScrollingMovementMethod());

    }
}