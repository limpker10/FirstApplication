package com.example.myapplication.Postulante;
import android.widget.EditText;
import java.io.Serializable;

public class Postulante implements Serializable{

    public String dni;
    public String edtNombres;
    public String edtPaterno;
    public String edtMaterno;
    public String edtFecNacimiento;
    public String edtColegio;
    public String edtCarrera;

    public Postulante(String edtNombres, String edtPaterno, String edtMaterno, String edtFecNacimiento, String edtColegio, String edtCarrera, String edtDNI) {
        this.edtNombres = edtNombres;
        this.edtPaterno = edtPaterno;
        this.edtMaterno = edtMaterno;
        this.edtFecNacimiento = edtFecNacimiento;
        this.edtColegio = edtColegio;
        this.edtCarrera = edtCarrera;
        this.dni = edtDNI;
    }

    public static Postulante createPostulante(EditText form [] ){
        return new Postulante(
                form[0].getText().toString(),
                form[1].getText().toString(),
                form[2].getText().toString(),
                form[3].getText().toString(),
                form[4].getText().toString(),
                form[5].getText().toString(),
                form[6].getText().toString()
        );
    }

    @Override
    public String toString() {
        return edtNombres + "--" +
               edtPaterno + "--" +
               edtMaterno + "--" +
               edtFecNacimiento + "--" +
               edtColegio + "--" +
               edtCarrera + "--" +
               dni;
    }
}