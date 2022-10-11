package com.example.firstapplication;

import android.widget.EditText;

import java.util.Date;

public class Postulante {

    private String edtNombres;
    private String edtPaterno;
    private String edtMaterno;
    private String edtFecNacimiento;
    private String edtColegio;
    private String edtCarrera;

    public Postulante(EditText edtNombres, EditText edtPaterno, EditText edtMaterno, EditText edtFecNacimiento, EditText edtColegio, EditText edtCarrera) {
        this.edtNombres = edtNombres.getText().toString();
        this.edtPaterno = edtPaterno.getText().toString();
        this.edtMaterno = edtMaterno.getText().toString();
        this.edtFecNacimiento = edtFecNacimiento.getText().toString();
        this.edtColegio = edtColegio.getText().toString();
        this.edtCarrera = edtCarrera.getText().toString();
    }

    @Override
    public String toString() {
        return "Postulante{" +
                "edtNombres='" + edtNombres + '\'' +
                ", edtPaterno='" + edtPaterno + '\'' +
                ", edtMaterno='" + edtMaterno + '\'' +
                ", edtFecNacimiento='" + edtFecNacimiento + '\'' +
                ", edtColegio='" + edtColegio + '\'' +
                ", edtCarrera='" + edtCarrera + '\'' +
                '}';
    }
}
