package com.cuc.projectapp.listpokeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView ListViewPokemon;
    List<Pokemon> lst;
    List<Pokemon> parsedPokemonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewPokemon = findViewById(R.id.ListViewPokemons);

        String apiUrl = "https://pogoapi.net/api/v1/pokemon_types.json";  // Reemplaza con la URL real de la API
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, apiUrl, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                // Procesar la respuesta JSON y llenar la lista con los datos
                parsedPokemonList = processJSON(response);

                // Después de obtener los datos de la API, actualiza el ListView
                Adapter adapter = new Adapter(MainActivity.this, parsedPokemonList);
                ListViewPokemon.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Manejar errores de la solicitud
            }
        });

        // Agregar la solicitud a la cola de Volley
        Volley.newRequestQueue(this).add(request);

        ListViewPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pokemon p = parsedPokemonList.get(i); // Utiliza parsedPokemonList en lugar de lst
                Toast.makeText(getBaseContext(), p.pokemon_name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    List<Pokemon> processJSON(JSONArray jsonArray) {
        List<Pokemon> retAr = new ArrayList<>();

        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String nombre = jsonObject.getString("pokemon_name");
                int id = jsonObject.getInt("pokemon_id");
                JSONArray typesArray = jsonObject.getJSONArray("type");
                String form = jsonObject.getString("form");
                List<String> types = new ArrayList<>();

                for (int j = 0; j < typesArray.length(); j++) {
                    types.add(typesArray.getString(j));
                }

                int img = getResources().getIdentifier(nombre.toLowerCase(), "drawable", getPackageName());
                retAr.add(new Pokemon(form, id, nombre,img));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return retAr;
    }

    private List<Pokemon> GetData() {
        //  System.out.println( response.size());


        lst=new ArrayList<>();
        Map<String, Integer> imagenRecursos = new HashMap<>();
        imagenRecursos.put("amaura", R.drawable.amaura);

        // lst.add(new Pokemon("Canto",1,"Amaura",imagenRecursos.get("Amaura".toLowerCase())));
        lst.add(new Pokemon("Canto",1,"Amaura"));

        return lst;


    }



}