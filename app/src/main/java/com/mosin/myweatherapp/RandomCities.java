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
        city.cityName = randomCityName();
        city.cityTemp = randomCityTemp();
        return city;
    }

    public Cities rndCity(){
        Cities cities = new Cities();
        return rndUpdateCities(cities);
    }

    private String randomCityName(){
        String[] cityName = resources.getStringArray(R.array.city_names);
        return cityName[randomCity.nextInt(cityName.length)];
    }

    private String randomCityTemp(){
        String[] cityTemp = resources.getStringArray(R.array.city_temp);
        return cityTemp[randomCity.nextInt(cityTemp.length)];
    }
}
