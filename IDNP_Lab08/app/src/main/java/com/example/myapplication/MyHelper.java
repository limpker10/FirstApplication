package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.example.myapplication.Postulante.Postulante;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MyHelper{

    private String filename;

    FragmentActivity activity;

    public MyHelper(FragmentActivity activity){
        this.activity = activity;
        this.filename = "demoFile.txt";
    }

    public MyHelper(AppCompatActivity activity, String filename){
        this.activity = activity;
        this.filename = filename;
    }

    //para hacer un almacenamiento interno================
    public void writeData(Postulante postulante) {
        try {
            FileOutputStream fos = this.activity.openFileOutput(filename, Context.MODE_APPEND);
            String data = postulante.toString()+"\n";
            fos.write(data.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //print
        Log.d("WRITE","Escritura de archivo " + filename + "completada...");
    }

    public ArrayList<Postulante> readData() {
        //Datos postulante================
        ArrayList<Postulante> listaGenerada = new ArrayList<>();
        String dataPostulante="";
        Postulante p;
        //===============================

        try {
            FileInputStream fin = this.activity.openFileInput(filename);
            int a;
            StringBuilder temp = new StringBuilder();
            while ((a = fin.read()) != -1) {
                if(a == '\n'){
                    dataPostulante = temp.toString();

                    //limpiamos el buffer
                    temp = new StringBuilder();

                    p = converterDataToPost(dataPostulante);
                    //agregamos postulante a lista
                    listaGenerada.add(p);

                }else {
                    temp.append((char) a);
                }
            }
            fin.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //print
        Log.d("READ","Lectura de acrhivo " + filename + " completada..");
        return listaGenerada;
    }

    private Postulante converterDataToPost(String pos) {
        Postulante postulante = null;
        String valor = pos;
        String[] lista = valor.split("--");

        postulante = new Postulante(
                lista[0],
                lista[1],
                lista[2],
                lista[3],
                lista[4],
                lista[5],
                lista[6]
        );

        return postulante;
    }

}
