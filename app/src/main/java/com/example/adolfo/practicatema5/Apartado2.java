package com.example.adolfo.practicatema5;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Apartado2 extends AppCompatActivity {
    Button btn_enviar;
    EditText et_titulo_mensaje, et_texto_mensaje, et_segundos_espera_notificacion;
    Toast toast_error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartado2);
        btn_enviar = findViewById(R.id.btn_enviar);
        et_titulo_mensaje = findViewById(R.id.et_titulo_mensaje);
        et_texto_mensaje = findViewById(R.id.et_texto_mensaje);
        et_segundos_espera_notificacion = findViewById(R.id.et_segundos_mensaje);
        toast_error = Toast.makeText(this, "Error, complete los campos", Toast.LENGTH_LONG);


        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(campos_vacios())
                {
                    Log.i("Main_A", getResources().getString(R.string.error_campos_vacios));
                    toast_error.show();
                }
                else {
                    NotificationCompat.Builder mBuilder;
                    NotificationManager mNotifyMgr = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

                    int icono = R.mipmap.ic_launcher;
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 0, i, 0);

                    mBuilder = new NotificationCompat.Builder(getApplicationContext())
                            .setContentIntent(pendingIntent)
                            .setSmallIcon(icono)
                            .setContentTitle(et_titulo_mensaje.getText().toString())
                            .setContentText(et_texto_mensaje.getText().toString())
                            .setVibrate(new long[]{100, 250, 100, 500})
                            .setAutoCancel(true)
                    ;

                    mNotifyMgr.notify(1, mBuilder.build());
                }
            }
        });
    }
    public boolean campos_vacios()
    {
        return (et_titulo_mensaje.getText().length()==0 || et_texto_mensaje.getText().length()==0||et_segundos_espera_notificacion.getText().length()==0);
    }
}
