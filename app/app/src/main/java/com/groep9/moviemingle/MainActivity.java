package com.groep9.moviemingle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button accountButton = findViewById(R.id.btn_main_account);

        accountButton.setOnClickListener(view -> {
            Intent accountIntent = new Intent(this, AccountActivity.class);
            startActivity(accountIntent);
        });

    }
}