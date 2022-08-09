package com.example.preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNome;
    private EditText edtAno;
    private Button btnOK;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtAno = findViewById(R.id.edtAno);
        btnOK = findViewById(R.id.btnOK);

        btnOK.setOnClickListener(this);

        prefs = getSharedPreferences("config", MODE_PRIVATE);

        String nome = prefs.getString("nome", null);
        if (nome != null){
            edtNome.setText(nome);
        }
        int ano = prefs.getInt("ano",-1);
        if(ano != -1){
            edtAno.setText(String.valueOf(ano));
        }



    }

    @Override
    public void onClick(View view) {
        String nome = edtNome.getText().toString();
        int ano = Integer.parseInt(edtAno.getText().toString());

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nome", nome);
        editor.putInt("ano", ano);
        editor.apply();

        Toast.makeText(this, "Dados gravados com sucesso!", Toast.LENGTH_SHORT).show();
    }
}