package com.mosin.myweatherapp.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.mosin.myweatherapp.modelDB.Cities;

import java.util.List;

@Dao
public interface EducationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCity(Cities city);

    @Update()
    void updateCity (Cities city);

    @Delete
    void deleteCity (Cities city);

    @Query("DELETE FROM cities WHERE cityName = :id")
    void deleteCityById(String id);

    @Query("SELECT * FROM cities")
    List<Cities> getAllCities();

    @Query("SELECT * FROM cities WHERE cityName = :id")
    Cities getCityById(String id);

    @Query("SELECT COUNT() FROM cities")
    long getCountCity();
}
