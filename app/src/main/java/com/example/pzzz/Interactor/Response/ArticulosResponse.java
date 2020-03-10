package com.example.pzzz.Interactor.Response;
import com.google.gson.annotations.SerializedName;

public class ArticulosResponse {

    @SerializedName("Folio")
    private String Folio;
    @SerializedName("Titulo")
    private String Titulo;
    @SerializedName("Categoria")
    private String Categoria;
    @SerializedName("Descripcion")
    private String text;
    @SerializedName("Precio")
    private String Precio;
    @SerializedName("img")
    private String img;

    public ArticulosResponse(String titulo, String categoria, String text, String precio, String img) {
        Titulo = titulo;
        Categoria = categoria;
        this.text = text;
        Precio = precio;
        this.img = img;
    }

    public String getFolio() {
        return Folio;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public String getText() {
        return text;
    }

    public String getPrecio() {
        return Precio;
    }

    public String getImg() {
        return img;
    }
}
