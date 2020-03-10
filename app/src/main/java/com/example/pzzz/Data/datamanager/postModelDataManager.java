package com.example.pzzz.Data.datamanager;

import com.example.pzzz.Data.dao.DaoSession;
import com.example.pzzz.Data.Model.postModel;
import com.example.pzzz.Interactor.MiProyectoApp;

import java.util.List;

public class postModelDataManager {

    private DaoSession daoSession;

    public postModelDataManager()
    {
        daoSession = MiProyectoApp.getDaoSession();
    }

    public List<postModel> getAll(String parametro)
    {
        //return daoSession.getPostModelDao().queryBuilder().where(
          //      postModelDao.Properties.Text.like("%"+parametro+"%")).un;
        return daoSession.getPostModelDao().loadAll();
    }

    public void savePosts(List<postModel> posts)
    {

        daoSession.getPostModelDao().insertInTx(posts);
    }
}
