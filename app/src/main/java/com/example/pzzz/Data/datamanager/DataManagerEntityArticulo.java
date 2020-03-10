package com.example.pzzz.Data.datamanager;

import com.example.pzzz.Data.dao.DaoSession;
import com.example.pzzz.Data.Model.Producto;
import com.example.pzzz.Router.App_ApiRoute;

import java.util.List;
public class DataManagerEntityArticulo {

    private DaoSession daoSession;

    public DataManagerEntityArticulo()
    {
        daoSession = App_ApiRoute.getDaoSession();
    }

    public List<Producto> getAll()
    {
        //return daoSession.getPostModelDao().queryBuilder().where(
        //      postModelDao.Properties.Text.like("%"+parametro+"%")).un;
        return daoSession.getProductoDao().loadAll();

    }

    public void saveArticulos(List<Producto> articulo){
        daoSession.getProductoDao().insertInTx(articulo);
    }

}
