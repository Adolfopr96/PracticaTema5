package com.example.adolfo.practicatema5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.adolfo.practicatema5.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    Button btn_principal1, btn_principal2;
    Intent i1, i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        btn_principal1= findViewById(R.id.btn_principal1);
        btn_principal2= findViewById(R.id.btn_principal2);
        i1 = new Intent(this, Apartado1.class);
        i2 = new Intent(this, Apartado2.class);

        btn_principal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i1);
            }
        });
        btn_principal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i2);
            }
        });
    }
}
