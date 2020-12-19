package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ListViewAdapter listViewAdapter;
    ArrayList<Pokemon> pokemonArrayList;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        pokemonArrayList = new ArrayList<>();

        String restApiURL = "https://next.json-generator.com/api/json/get/E14trR2lD";
        //String restApiURL = "https://api.github.com/repositories";


            try {
                String data = new Asycdata().execute(restApiURL).get();

                System.out.println("Data From Rest API : "+data);

/*

                JSONArray gitArray = new JSONArray(data);

                for (int i = 0;i<gitArray.length();i++)
                {
                    JSONObject cOb = gitArray.getJSONObject(i);
                    System.out.println("Repo  Name : "+ cOb.getString("name"));
                    JSONObject childcOb = cOb.getJSONObject("owner");
                    System.out.println("Owner Name : "+ childcOb.getString("login"));
                }
*/


                JSONObject mainObject = new JSONObject(data);
                JSONArray pJSONArray =  mainObject.getJSONArray("Pokemon");

                for (int i=0;i<pJSONArray.length();i++)
                {
                    JSONObject childObject = pJSONArray.getJSONObject(i);

                    String name = childObject.getString("name");
                    String imageUrl = childObject.getString("image");
                    String type = childObject.getString("type");
                    String ability = childObject.getString("ability");
                    String height = childObject.getString("height");
                    String weight = childObject.getString("weight");
                    String desc = childObject.getString("description");

                    pokemonArrayList.add(new Pokemon(name,imageUrl,type,ability,height,weight,desc));

                }

                listViewAdapter = new ListViewAdapter(pokemonArrayList,getApplication());

                listView.setAdapter(listViewAdapter);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                        Intent intent = new Intent(MainActivity.this,Pokemondesc.class);
                        intent.putExtra("poke",pokemonArrayList.get(position));
                        startActivity(intent);
                    }
                });

            }catch (ExecutionException | InterruptedException | JSONException executionException)
            {
                Log.e("MainActivity", executionException.getMessage());
            }


    }
}