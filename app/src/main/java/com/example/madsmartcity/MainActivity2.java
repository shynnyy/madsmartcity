package com.example.madsmartcity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity2 extends AppCompatActivity {
    Button btnS1, btnS2, btnS3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize buttons
        btnS1 = findViewById(R.id.btnScene1);
        btnS2 = findViewById(R.id.btnScene2);
        btnS3 = findViewById(R.id.btnScene3);

        // Set onClickListeners for each button to replace fragments
        btnS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, new Scene1())  // Create a new instance of Scene1
                        .setReorderingAllowed(true)
                        .addToBackStack("scene1")  // Changed name to be more descriptive
                        .commit();
            }
        });

        btnS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, new Scene2())  // Create a new instance of Scene2
                        .setReorderingAllowed(true)
                        .addToBackStack("scene2")  // Changed name to be more descriptive
                        .commit();
            }
        });

        btnS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, new Scene3())  // Create a new instance of Scene3
                        .setReorderingAllowed(true)
                        .addToBackStack("scene3")  // Changed name to be more descriptive
                        .commit();
            }
        });
    }
}
