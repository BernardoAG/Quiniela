package com.example.bernardoaltamirano.quiniela;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {

    private EditText user, psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        user = (EditText) findViewById(R.id.txUsername);
        psw = (EditText) findViewById(R.id.txPsw);

    }
    public void delete(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        int fila = db.delete("quinielas, players", "quinielas.username=" + user.getText().toString()+" AND players.username=" + user.getText().toString()+" AND players.password=" +psw.getText().toString(), null);
        if (fila > 0)
            Toast.makeText(this, "Quiniela has been deleted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Quiniela couldnt be deleted", Toast.LENGTH_SHORT).show();

    }

}
