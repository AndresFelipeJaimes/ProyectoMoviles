package com.example.proyectomoviles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectomoviles.iscmodel;
import java.util.List;

public class iscadapter extends RecyclerView.Adapter<iscadapter.ViewHolder> {
    private Context context;
    private List<iscmodel> iscModelList;

    public iscadapter   (Context context, List<iscmodel> iscModelList) {
        this.context = context;
        this.iscModelList = iscModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iscbook, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        iscmodel iscModel = iscModelList.get(position);

        // Utiliza Glide para cargar la imagen desde la URL en el ImageView
        Glide.with(context).load(iscModel.getUrl()).into(holder.imageView);

        // Establece el nombre, descripción y precio en los TextViews
        holder.name.setText(iscModel.getName());
        holder.des.setText(iscModel.getDescription());
        // El precio es de tipo Double, debes convertirlo a String para mostrarlo en un TextView.
        holder.price.setText(String.valueOf(iscModel.getPrice()));
    }

    @Override
    public int getItemCount() {
        // aqui puede ser return 0;
        return iscModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, des, price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iscimage);
            name = itemView.findViewById(R.id.iscbookname);
            des = itemView.findViewById(R.id.iscdes);
            price = itemView.findViewById(R.id.iscprice);
        }
    }
}
