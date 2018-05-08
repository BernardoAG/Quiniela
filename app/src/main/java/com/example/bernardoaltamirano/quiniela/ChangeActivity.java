package com.example.bernardoaltamirano.quiniela;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChangeActivity extends AppCompatActivity {
    private EditText mail, psw, pswO,pswC, user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        mail = (EditText) findViewById(R.id.txMail);
        psw = (EditText) findViewById(R.id.txPsw);
        pswC=(EditText) findViewById(R.id.txPsw2);
        pswO=(EditText) findViewById(R.id.txPswO);
        user=(EditText) findViewById(R.id.txUsername);      //guardar como una session del user
    }
    public void change(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues cv = new ContentValues();
        if(psw.equals(pswC)){
            cv.put("mail",mail.toString());
            cv.put("password",psw.toString());
            int fila = db.update("players", cv,"username=" + user.getText().toString(),null)  ;
            if (fila > 0)
                Toast.makeText(this, "Quiniela has been deleted", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Quiniela couldnt be deleted", Toast.LENGTH_SHORT).show();
        }

    }
}
