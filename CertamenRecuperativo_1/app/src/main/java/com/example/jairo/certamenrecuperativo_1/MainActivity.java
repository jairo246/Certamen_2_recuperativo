package com.example.jairo.certamenrecuperativo_1;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity{

    EditText nombre_edit;
    EditText apellido_edit;
    Button botton_internet;
    TextView texto_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre_edit = (EditText) findViewById(R.id.nombre_view);
        apellido_edit = (EditText) findViewById(R.id.apellido_view);
        botton_internet = (Button) findViewById(R.id.button);
        texto_view = (TextView) findViewById(R.id.texto);

        botton_internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombre_edit.toString();
                String apellido = apellido_edit.toString();

                String URL = "http://api.icndb.com/jokes/random?firstName="+nombre+"&lastName="+apellido;

                BackGroundTask backGroundTask = new BackGroundTask(this,URL);
                texto_view.setText(backGroundTask.joke);

            }
        });


    }
}
