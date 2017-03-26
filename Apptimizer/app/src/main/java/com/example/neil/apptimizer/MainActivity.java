package com.example.neil.apptimizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import 	android.util.Log;
import java.util.logging.Logger;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_page);
    }

    public void onSplashPageClick(View view) {
        Intent intent = new Intent(this, questions.class);
        startActivity(intent);
    }
}