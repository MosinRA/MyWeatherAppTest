package com.mosin.myweatherapp.modelDB;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = {"city_name", "city_temp"})})
public class Cities {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "city_name")
    public String cityName;

    @ColumnInfo(name = "city_temp")
    public String cityTemp;

}
