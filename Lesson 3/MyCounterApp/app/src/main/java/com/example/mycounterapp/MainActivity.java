package com.example.mycounterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private TextView countertext;
    private Button plus;
    private Button minus;
    private Button reset;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        countertext=(TextView) findViewById(R.id.counterText);
        minus=(Button) findViewById(R.id.minusbutton);
        plus=(Button) findViewById(R.id.plusbutton);
        reset=(Button)findViewById(R.id.resetbutton);

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minusCounter();
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusCounter();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCounter();
            }
        });

        resetCounter();

    }

    public void resetCounter(){
        counter =0;
        countertext.setText(counter+"");
    }
    private void plusCounter(){
        counter++;
        countertext.setText(counter+"");
    }
    private void minusCounter(){
        counter--;
        countertext.setText(counter+"");
    }
}