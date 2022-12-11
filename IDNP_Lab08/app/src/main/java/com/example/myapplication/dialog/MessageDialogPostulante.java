package com.example.myapplication.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication.R;

public class MessageDialogPostulante extends DialogFragment {
    //Data
    private static final String ARG_PARAM = "description";

    static public MessageDialogPostulante newInstance(String descripcionPostulante) {
        //se referencia asi mismo
        MessageDialogPostulante p = new MessageDialogPostulante();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, descripcionPostulante);
        p.setArguments(args);
        return p;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //recibiendo por el flujo de datos
        final String cargoMiembro = getArguments().getString(ARG_PARAM);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        //enlazando con el layaout que va en el dialogo
        View view = inflater.inflate(R.layout.dialog_message_description_postulante, null);

        //Descripcion de postulante insertada en el dialogo
        TextView txtDescriptionPostulante = view.findViewById(R.id.insertarDescripcionPostulante);
        txtDescriptionPostulante.setText(cargoMiembro);

        builder.setView(view);
        return builder.create();
    }

}
