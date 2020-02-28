package com.example.alertdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static androidx.appcompat.app.AlertDialog.*;

public class MainActivity extends AppCompatActivity {

    String[] pokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pokemon = getResources().getStringArray(R.array.pokemon);
        Button alert = findViewById(R.id.alert);

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                //builder.setMessage("Papasa ba ako Sir Aki")
                        builder.setItems(R.array.pokemon, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                Toast.makeText(getApplicationContext(),"You chose" +pokemon[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setTitle("Whoops!!")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                Toast.makeText(getApplicationContext(), "Hahahaha", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                Toast.makeText(getApplicationContext(), "Papasa na talaga", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("Maybe", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                Toast.makeText(getApplicationContext(), "Oh my!!", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });
    }
}
