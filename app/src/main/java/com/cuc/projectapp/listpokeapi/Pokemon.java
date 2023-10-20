package com.cuc.projectapp.listpokeapi;

import java.lang.reflect.Array;

public class Pokemon {

    public int pokemon_image;
    public String from;
    public int pokemon_id;
    public String pokemon_name;
    public Array type;

    public Pokemon() {
        this.pokemon_image = 0;
        this.from = null;
        this.pokemon_id = 0;
        this.pokemon_name = null;
        this.type = null;
    }

    public Pokemon(String from, int pokemon_id, String pokemon_name, Array type,int pokemon_image) {
        this.pokemon_image = pokemon_image;
        this.from = from;
        this.pokemon_id = pokemon_id;
        this.pokemon_name = pokemon_name;
        this.type = type;
    }

    public Pokemon(String from, int pokemon_id, String pokemon_name) {
        this.from = from;
        this.pokemon_id = pokemon_id;
        this.pokemon_name = pokemon_name;
    }
    public Pokemon(String from, int pokemon_id, String pokemon_name,int pokemon_image) {
        this.pokemon_image = pokemon_image;
        this.from = from;
        this.pokemon_id = pokemon_id;
        this.pokemon_name = pokemon_name;
    }
    public Pokemon(int pokemon_id, String pokemon_name,int pokemon_image) {
        this.pokemon_id = pokemon_id;
        this.pokemon_name = pokemon_name;
        this.pokemon_image = pokemon_image;

    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getPokemon_id() {
        return pokemon_id;
    }

    public void setPokemon_id(int pokemon_id) {
        this.pokemon_id = pokemon_id;
    }

    public String getPokemon_name() {
        return pokemon_name;
    }

    public void setPokemon_name(String pokemon_name) {
        this.pokemon_name = pokemon_name;
    }

    public Array getType() {
        return type;
    }

    public void setType(Array type) {
        this.type = type;
    }

    public int getPokemon_image() {
        return pokemon_image;
    }

    public void setPokemon_image(int pokemon_image) {
        this.pokemon_image = pokemon_image;
    }
}
