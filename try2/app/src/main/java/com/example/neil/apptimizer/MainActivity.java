package com.example.neil.apptimizer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import static android.widget.AdapterView.*;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity implements OnItemClickListener{

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        /*if (parent.getId()==R.id.gridview)
            switch (position){
                case 0:{
                    startActivity(new Intent(this);
                    break;
                }
                case 1:{
                    startActivity(new Intent(this));
                    break;
                }
                case 2:{
                    startActivity(new Intent(this));
                    break;
                }
                case 3:{
                    startActivity(new Intent(this));
                    break;
                }
                case 4:{
                    startActivity(new Intent(this, AnimationActivity001.class));
                    break;
                }
                case 5:{
                    startActivity(new Intent(this, AnimationActivity001.class));
                    break;
                }
            }*/
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        Log.d("HERE","YO");
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_LONG).show();
            }
        });

        // BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
