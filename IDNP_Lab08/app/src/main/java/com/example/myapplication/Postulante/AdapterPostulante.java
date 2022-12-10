package com.example.myapplication.Postulante;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class AdapterPostulante extends RecyclerView.Adapter<AdapterPostulante.ViewHolderData> {

    private ArrayList<Postulante> listPostulantes;

    public AdapterPostulante(ArrayList<Postulante> listaPostulantes) {
        this.listPostulantes = listaPostulantes;
    }

    @NonNull
    @Override
    public AdapterPostulante.ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflamos el view y lo retornamos
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view_postulante, null, false);
        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPostulante.ViewHolderData holder, int position) {
        holder.cargarDatos(listPostulantes.get(position));
    }

    @Override
    public int getItemCount() {
        return listPostulantes.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {

        private TextView namePostulante;

        public ViewHolderData(@NonNull View itemView) {
            super(itemView);
            this.namePostulante = itemView.findViewById(R.id.idTextNamePostulante);
        }

        public void cargarDatos(Postulante postulante) {
            namePostulante.setText(postulante.edtPaterno + " "+
                    postulante.edtMaterno + ", " +
                    postulante.edtNombres);
        }
    }
}
