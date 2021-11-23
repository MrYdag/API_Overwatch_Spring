package com.example.api_overwatch_2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String gamemode;
    private String country;

    public Map(){ }

    public Map(int id, String name, String gamemode, String country){
        this.id = id;
        this.name = name;
        this.gamemode = gamemode;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGamemode() {
        return gamemode;
    }

    public String getCountry() {
        return country;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGamemode(String gamemode) {
        this.gamemode = gamemode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Map{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gamemode='" + gamemode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
