package com.example.adolfo.practicatema5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Apartado1 extends AppCompatActivity {
    Button btn_generar;
    RadioButton rb_horizontal1, rb_horizontal2, rb_horizontal3, rb_vertical1, rb_vertical2, rb_vertical3;
    EditText et_texto, et_ejeX, et_ejeY;
    String result_horizontal, result_vertical,result_text;
    Toast toast_principal;
    Toast toast_error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartado1);
        btn_generar = findViewById(R.id.btn_generar_toast);
        rb_horizontal1 = findViewById(R.id.rb_horizontal1);
        rb_horizontal2 = findViewById(R.id.rb_horizontal2);
        rb_horizontal3 = findViewById(R.id.rb_horizontal3);
        rb_vertical1 = findViewById(R.id.rb_vertical1);
        rb_vertical2 = findViewById(R.id.rb_vertical2);
        rb_vertical3 = findViewById(R.id.rb_vertical3);
        et_texto = findViewById(R.id.et_texto_apartado1);
        et_ejeX = findViewById(R.id.et_ejeX);
        et_ejeY = findViewById(R.id.et_ejeY);
        toast_error = Toast.makeText(this, "Error, complete los campos", Toast.LENGTH_LONG);

        btn_generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(campos_vacios())
                {
                    Log.i("Main_A", getResources().getString(R.string.error_campos_vacios));
                   toast_error.show();

                }
                else
                    {
                    configurar_toast();
                }
                }
        });

    }
    public void configurar_toast()
    {
        int reH=0;
        int reV=0;
        if(rb_horizontal1.isChecked())
        {
            reH=3;
        }
        else  if (rb_horizontal2.isChecked())
        {
            reH=1;
        }
        else if (rb_horizontal3.isChecked())
        {
            reH=5;
        }
        if(rb_vertical1.isChecked())
        {
            reV=48;
        }
        else if(rb_vertical2.isChecked())
        {
            reV=16;
        }
        else if(rb_vertical3.isChecked())
        {
            reV=80;
        }
        toast_principal = Toast.makeText(this, et_texto.getText().toString(), Toast.LENGTH_LONG);
        toast_principal.setGravity(reH|reV, Integer.parseInt(et_ejeX.getText().toString()), Integer.parseInt(et_ejeY.getText().toString()));

    }
    public boolean campos_vacios()
    {
        return (et_ejeX.getText().length()==0|| et_ejeY.getText().length()==0 || et_texto.getText().length()==0||!rb_horizontal1.isChecked()&&!rb_horizontal2.isChecked()&&!rb_horizontal3.isChecked()||(!rb_vertical1.isChecked()&&!rb_vertical2.isChecked()&&!rb_vertical3.isChecked()));
    }
}