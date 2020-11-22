package com.mosin.myweatherapp.dataBase;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mosin.myweatherapp.dao.EducationDao;
import com.mosin.myweatherapp.modelDB.Cities;

@Database(entities = {Cities.class}, version = 1, exportSchema = false)
public abstract class EducationDatabase extends RoomDatabase {
    public abstract EducationDao getEducationDao();
}
