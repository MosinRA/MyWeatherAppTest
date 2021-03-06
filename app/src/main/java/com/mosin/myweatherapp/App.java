package com.mosin.myweatherapp;

import android.app.Application;

import androidx.room.Room;

import com.mosin.myweatherapp.dao.EducationDao;
import com.mosin.myweatherapp.dataBase.EducationDatabase;

public class App extends Application {

    private static App instance;

    private EducationDatabase db;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        db = Room.databaseBuilder(
                getApplicationContext(),
                EducationDatabase.class,
                "city_database")
                .allowMainThreadQueries()
                .build();
    }

    public EducationDao getEducationDao(){
        return db.getEducationDao();
    }
}
