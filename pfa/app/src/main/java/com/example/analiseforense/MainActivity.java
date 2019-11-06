package com.example.analiseforense;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textViewContatos, textViewSms;
    private String[] permissoes = {Manifest.permission.READ_CONTACTS, Manifest.permission.READ_SMS};
    public static final int MY_PERMISSIONS_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewContatos = findViewById(R.id.textViewContatos);
        textViewSms = findViewById(R.id.textViewSms);
        textViewContatos.setText("Sem Permissão");
        textViewSms.setText("Sem Permissão");
        solicitapermissaoContatos();
    }

    public void solicitapermissaoContatos() {

        List<String> permissoesRequeridas = new ArrayList<>();

        for (String appPermissao : permissoes) {
            if (ContextCompat.checkSelfPermission(this, appPermissao) != PackageManager.PERMISSION_GRANTED) {

                permissoesRequeridas.add(appPermissao);
            }
        }
        if(!permissoesRequeridas.isEmpty()){
            ActivityCompat.requestPermissions(this, permissoesRequeridas.toArray(new String[permissoesRequeridas.size()]), MY_PERMISSIONS_REQUEST);

        }
    }
}