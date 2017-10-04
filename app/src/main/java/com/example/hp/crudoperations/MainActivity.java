package com.example.hp.crudoperations;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    RecordDatabase myDb;
 EditText E1,E2,E3,E4,E5;
   Button B1,B2,B3,B4;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new RecordDatabase(this);

        E2=(EditText)findViewById(R.id.e2);
        E3=(EditText)findViewById(R.id.e3);
        E4=(EditText)findViewById(R.id.e4);
        E5=(EditText)findViewById(R.id.e5);
        B1=(Button)findViewById(R.id.b1);
        B2=(Button)findViewById(R.id.b2);
        B3=(Button)findViewById(R.id.b3);
        B4=(Button)findViewById(R.id.b4);
        AddData();
    }
  public void AddData()
    {
      B1.setOnClickListener(
              new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      boolean res = myDb.Insert_data(E2.getText().toString(), E3.getText().toString(), E4.getText().toString(), Integer.parseInt(E5.getText().toString()));
                      if (res == true) {
                          Toast.makeText(MainActivity.this, "inserting record", Toast.LENGTH_LONG).show();
                      } else {

                          Toast.makeText(MainActivity.this, "some error occure while inserting record", Toast.LENGTH_LONG).show();
                      }
                  }
              });

       }




}
