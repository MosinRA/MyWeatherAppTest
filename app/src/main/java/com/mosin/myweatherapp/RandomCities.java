package com.mosin.myweatherapp;

import android.content.res.Resources;

import com.mosin.myweatherapp.modelDB.Cities;

import java.util.Random;

public class RandomCities {

    private Resources resources;
    private Random randomCity = new Random();

    public RandomCities(Resources resources){
        this.resources = resources;
    }

    public Cities rndUpdateCities(Cities city){
        city.cityName = "randomCityName()";
        city.cityTemp = "randomCityTemp()";
        return city;
    }

    public Cities rndCity(){
        Cities cities = new Cities();
        return rndUpdateCities(cities);
    }

    private String randomCityName(){
        String[] cityName = {"Surgut"};
        return cityName[0];
    }

    private String randomCityTemp(){
        String[] cityTemp = {"2"};
        return cityTemp[0];
    }
}
