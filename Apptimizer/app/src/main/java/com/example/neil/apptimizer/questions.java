package com.example.neil.apptimizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.view.MotionEvent;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import java.io.IOException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.DataOutputStream;
// Apache Http Client
import java.net.URLConnection;
import java.io.DataInputStream;
import java.net.URLEncoder;

public class questions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
    }

    public void onHintClick(View view) {

        Toast toasty = Toast.makeText(getApplicationContext(), getString(R.string.H1), Toast.LENGTH_SHORT);
        toasty.show();

    }

    public void onAnswerClick(View view) {

        String answer = ((EditText) findViewById(R.id.answer)).getText().toString();
        String correctanswer = getString(R.string.A1);

        if (answer.equals(correctanswer)) {
            Toast toasty = Toast.makeText(getApplicationContext(), "Right!", Toast.LENGTH_SHORT);
            toasty.show();

        } else {
            Toast toasty = Toast.makeText(getApplicationContext(), "Nope!", Toast.LENGTH_SHORT);
            toasty.show();
        }
    }

    // Overriding onTouchEvent to test user IO
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        float x_coord, y_coord;
        String DEBUG_TAG = "Touch Event";
        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Log.d(DEBUG_TAG, "Action was DOWN");
                x_coord = event.getRawX();
                y_coord = event.getRawY();
                Log.d(DEBUG_TAG, Float.toString(x_coord));
                Log.d(DEBUG_TAG, Float.toString(y_coord));
                sendPostRequest();
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

    void sendPostRequest() {
        try {
            URL url;
            URLConnection urlConn;
            DataOutputStream printout;
            DataInputStream  input;
            url = new URL ("http://arashrai.com:5000/hack");
            urlConn = url.openConnection();
            urlConn.setDoInput (true);
            urlConn.setDoOutput (true);
            urlConn.setUseCaches (false);
            urlConn.setRequestProperty("Content-Type","application/json");
            urlConn.setRequestProperty("Host", "android.schoolportal.gr");
            urlConn.connect();
            //JSONObject
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("ID", "25");
            jsonParam.put("description", "Real");
            jsonParam.put("enable", "true");

            // Send POST output.
            printout = new DataOutputStream(urlConn.getOutputStream ());
            printout.writeBytes(URLEncoder.encode(jsonParam.toString(),"UTF-8"));
            printout.flush ();
            printout.close ();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}