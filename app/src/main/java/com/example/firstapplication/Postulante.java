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

    public Postulante(String edtNombres, String edtPaterno, String edtMaterno, String edtFecNacimiento, String edtColegio, String edtCarrera) {
        this.edtNombres = edtNombres;
        this.edtPaterno = edtPaterno;
        this.edtMaterno = edtMaterno;
        this.edtFecNacimiento = edtFecNacimiento;
        this.edtColegio = edtColegio;
        this.edtCarrera = edtCarrera;
    }

    public static Postulante createPostulante(EditText form [] ){

        return new Postulante(
                form[0].getText().toString(),
                form[1].getText().toString(),
                form[2].getText().toString(),
                form[3].getText().toString(),
                form[4].getText().toString(),
                form[5].getText().toString()
        );

    }
    @Override
    public String toString() {
        return "Postulante{" +
                "edtNombres='" + edtNombres + '\n' +
                ", edtPaterno='" + edtPaterno + '\n' +
                ", edtMaterno='" + edtMaterno + '\n' +
                ", edtFecNacimiento='" + edtFecNacimiento + '\n' +
                ", edtColegio='" + edtColegio + '\n' +
                ", edtCarrera='" + edtCarrera + '\n' +
                '}';
    }
}
