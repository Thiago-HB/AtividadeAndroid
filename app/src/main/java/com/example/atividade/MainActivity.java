package com.example.atividade;

import static com.example.atividade.R.id.ToolbarTela1;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button config, sair;
View.OnClickListener listener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(view.getId()==config.getId()){
            Intent intent = new Intent(MainActivity.this, ConfigActivity.class);
            startActivity(intent);
        }else if(view.getId()==sair.getId()){
            finishAffinity();
        }
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        config = findViewById(R.id.ConfigTela1);
        config.setOnClickListener(listener);
        sair = findViewById(R.id.ExitTela1);
        sair.setOnClickListener(listener);
        LoginDialog loginDialog = new LoginDialog();
        loginDialog.show(getSupportFragmentManager(), "LoginDialog");

    }
}