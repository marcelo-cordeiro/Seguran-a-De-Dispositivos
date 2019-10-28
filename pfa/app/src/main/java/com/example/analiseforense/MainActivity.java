package com.example.analiseforense;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewContatos,textViewSms;

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

        int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_CONTACTS)) {
            } else {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        } else {
            textViewContatos.setText("OK");
        }
    }
}
