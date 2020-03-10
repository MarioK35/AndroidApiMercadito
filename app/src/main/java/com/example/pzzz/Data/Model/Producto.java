package com.example.pzzz.Data.Model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Producto {

    private String Folio;
    private String Titulo;
    private String Categoria;
    private String text;
    private String Precio;
    private String img;
    @Generated(hash = 1435560044)
    public Producto(String Folio, String Titulo, String Categoria, String text,
            String Precio, String img) {
        this.Folio = Folio;
        this.Titulo = Titulo;
        this.Categoria = Categoria;
        this.text = text;
        this.Precio = Precio;
        this.img = img;
    }
    @Generated(hash = 549390722)
    public Producto() {
    }
    public String getFolio() {
        return this.Folio;
    }
    public void setFolio(String Folio) {
        this.Folio = Folio;
    }
    public String getTitulo() {
        return this.Titulo;
    }
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }
    public String getCategoria() {
        return this.Categoria;
    }
    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getPrecio() {
        return this.Precio;
    }
    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
   

}
