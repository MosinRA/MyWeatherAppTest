package com.mosin.myweatherapp;

import com.mosin.myweatherapp.dao.EducationDao;
import com.mosin.myweatherapp.modelDB.Cities;

import java.util.List;

public class EducationSource {

    private final EducationDao educationDao;

    private List<Cities> cities;

    public EducationSource(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    public List<Cities> getCities(){
        if (cities == null){
            LoadCities();
        }
        return cities;
    }

    public void LoadCities(){
        cities = educationDao.getAllCities();
    }

    public long getCountCities(){
        return educationDao.getCountCity();
    }

    public void addCity (Cities city){
        educationDao.insertCity(city);
    }

    public void updateCity (Cities city){
        educationDao.updateCity(city);
        LoadCities();
    }


}
