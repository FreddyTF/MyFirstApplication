package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);
        textView.setText("Lieber Chef, bitte genehmigen Sie den Urlaub!");


        View viewById = findViewById(R.id.imageView);

        button.setOnClickListener(v -> {
            textView.setText("Urlaub ist genehmigt");
            viewById.setScaleX(0);
            viewById.animate().scaleX(1.0f).setDuration(2000);

        });

        findViewById(R.id.imageView).animate().scaleX(1.0f).setDuration(2000);
    }
}