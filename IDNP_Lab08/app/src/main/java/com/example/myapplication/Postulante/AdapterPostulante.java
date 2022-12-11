package com.example.myapplication.Postulante;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.View.Rectangulo;
import com.example.myapplication.dialog.MessageDialogPostulante;

import java.util.ArrayList;

public class AdapterPostulante extends RecyclerView.Adapter<AdapterPostulante.ViewHolderData> {

    private ArrayList<Postulante> listPostulantes;
    private FragmentActivity activity;

    public AdapterPostulante(ArrayList<Postulante> listaPostulantes, FragmentActivity activity) {
        this.listPostulantes = listaPostulantes;
        this.activity = activity;
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
        holder.cargarDatos(listPostulantes.get(position), activity);
    }

    @Override
    public int getItemCount() {
        return listPostulantes.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {

        private String data; //contiene todos los datos de un postulante
        private TextView namePostulante;
        private Rectangulo onClickDescriptionPostulante;
        private FragmentActivity activity; //para abrir otros fragments

        public ViewHolderData(@NonNull View itemView) {
            super(itemView);
            this.namePostulante = itemView.findViewById(R.id.idTextNamePostulante);
            this.onClickDescriptionPostulante = itemView.findViewById(R.id.contentViewItemPostulante);
        }

        public void cargarDatos(Postulante postulante, FragmentActivity activity) {
            this.namePostulante.setText(postulante.edtPaterno + " "+
                    postulante.edtMaterno + ", " +
                    postulante.edtNombres);
            this.onClickDescriptionPostulante.setOnClickListener(eventoParaVerDescripcionPostulante);
            this.data = postulante.printData();
            this.activity = activity;
        }

        private View.OnClickListener eventoParaVerDescripcionPostulante = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessageDialogPostulante.newInstance(
                                data)
                        .show(activity.getSupportFragmentManager(), null);
            }
        };
    }
}
