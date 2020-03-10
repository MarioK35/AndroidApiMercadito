package com.example.pzzz.Interactor;

import android.app.Application;
import com.example.pzzz.Data.dao.DaoMaster;
import com.example.pzzz.Data.dao.DaoSession;
import com.facebook.stetho.Stetho;

import org.greenrobot.greendao.database.Database;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MiProyectoApp extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        daoSession =new DaoMaster(
                new DaoMaster.DevOpenHelper(this,"demo")
                        .getWritableDb()).newSession();

        Database database = daoSession.getDatabase();

        DaoMaster.createAllTables(database,true);
    }

    public static Retrofit getRetrofit()
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }

    public static DaoSession getDaoSession()
    {
        return daoSession;
    }
}
