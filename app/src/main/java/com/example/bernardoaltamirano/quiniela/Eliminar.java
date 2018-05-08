package com.example.bernardoaltamirano.quiniela;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Eliminar extends AppCompatActivity {

    private EditText mail, psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        mail = (EditText) findViewById(R.id.txMail);
        psw = (EditText) findViewById(R.id.txPsw);

    }
}
