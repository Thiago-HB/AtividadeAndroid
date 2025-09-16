package com.example.atividade;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigActivity extends AppCompatActivity {
private SharedPreferences preferences;
private SharedPreferences.Editor editor;
private EditText editNome;
private EditText editPassword;
private EditText editPassword2;
private Button entrar;
private Button sair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_activity);
      preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
      String nomeRecuperado = preferences.getString("nome","El Hermano");
      String senhaRecuperada = preferences.getString("senha", "12345");
      editNome = findViewById(R.id.editNome);
      editNome.setText(nomeRecuperado);
        editPassword = findViewById(R.id.editPassword);
        editPassword.setText(senhaRecuperada);
        editPassword2 = findViewById(R.id.confirmPassword);
        editPassword2.setText(senhaRecuperada);
        entrar = findViewById(R.id.botaoSair);
        entrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editor = preferences.edit();
                if (view.getId() == entrar.getId()) {
                    if (String.valueOf(editPassword)== String.valueOf(editPassword2)&&
                            !TextUtils.isEmpty((CharSequence) editNome)&&
                    String.valueOf(editPassword).length()>=8) {
                        editor.putString("nome", String.valueOf(editNome));
                        editor.putString("senha", String.valueOf(editPassword));
                    }
                    else{
                        Toast toast = new Toast(ConfigActivity.this);
                        toast.setText("Algo deu errado, favor rever nome e senha");
                    }
                    }
            }
        });
sair = findViewById(R.id.botaoSair);
sair.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View view){
        if (view.getId() == sair.getId()) {
            Intent intent = new Intent(ConfigActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
});

    }


}