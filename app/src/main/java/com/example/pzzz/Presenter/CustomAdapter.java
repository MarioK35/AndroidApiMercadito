package com.example.pzzz.Presenter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.pzzz.R;
import com.example.pzzz.Interactor.Response.PostResponse;
import com.example.pzzz.View.ViewPost;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    List<PostResponse> data;
    Context context;

    public CustomAdapter(List<PostResponse> data, Context context)
    {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.custom_adapter,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.textView.setText(data.get(position).getTitle());
        holder.textView2.setText(data.get(position).getText());
        holder.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context,"aqui se pushó al "+ data.get(position).getId(),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context, ViewPost.class);
                intent.putExtra("titulo",data.get(position).getTitle());
                intent.putExtra("texto",data.get(position).getText());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
            return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        TextView textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.adapter_txtv);
            textView2 = itemView.findViewById(R.id.adapter_txtv2);
        }
    }
}
