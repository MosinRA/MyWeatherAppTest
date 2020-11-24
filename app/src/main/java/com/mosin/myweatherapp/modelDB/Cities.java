package com.mosin.myweatherapp.modelDB;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = {"date", "city_temp"})})
public class Cities {
    @NonNull
    @PrimaryKey()
    public String cityName;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "city_temp")
    public String cityTemp;

//    @ColumnInfo(name = )

}
