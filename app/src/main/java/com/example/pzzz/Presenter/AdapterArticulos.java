package com.example.pzzz.Presenter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.pzzz.R;
import com.example.pzzz.Interactor.Response.ArticulosResponse;
import com.example.pzzz.View.ArticulosAll;
import com.example.pzzz.View.ArticulosPost;
import com.example.pzzz.View.EditArticulo;

import java.util.List;

public class AdapterArticulos extends RecyclerView.Adapter<AdapterArticulos.ViewHolder> {

    List<ArticulosResponse> data;
    Context context;

    public AdapterArticulos(List<ArticulosResponse> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.adapter_custom_product,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textTitulo.setText(data.get(position).getTitulo());
        holder.textDescripcion.setText(data.get(position).getText());
        holder.textCategoria.setText(data.get(position).getCategoria());
        holder.textPrecio.setText("$"+data.get(position).getPrecio());
        holder.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(context, ArticulosPost.class);
                context.startActivity(intent1);
            }
        });
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Intent intent = new Intent(contex, ArticulosAll.class);

                // .
                // context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textTitulo,
                textDescripcion,
                textPrecio,
                textCategoria;

        Button btn_edit,btn_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitulo = itemView.findViewById(R.id.txtv_titulo);
            textDescripcion = itemView.findViewById(R.id.txtv_descripcion);
            textPrecio = itemView.findViewById(R.id.txtv_precio);
            textCategoria = itemView.findViewById(R.id.txtv_categorias);
            btn_edit = itemView.findViewById(R.id.btn_edit);
            btn_delete = itemView.findViewById(R.id.btn_delete);

        }
    }

}
