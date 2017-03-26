package com.example.neil.apptimizer;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

// Apache Http Client
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            postCoords("BACK_BUTTON", 0, 0);
        }
        return super.onKeyDown(keyCode, event);
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
                postCoords("ACTION_DOWN", x_coord, y_coord);
                return true;
            default:
                return super.onTouchEvent(event);
        }

    }

    public void postCoords(String action, float x, float y) {

        JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("event", action);
            jsonParams.put("x", x);
            jsonParams.put("y", y);
        } catch (JSONException e) {
            Log.e("MYAPP", "unexpected JSON exception", e);
        }

        AsyncHttpClient client = new AsyncHttpClient();
        ByteArrayEntity entity = null;
        try {
            entity = new ByteArrayEntity(jsonParams.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

        client.post(null, "http://arashrai.com:5000/hack", entity, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                // called before request is started
                Log.d("ke", "onStart");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                Log.d("ke", "success");
                try {
                    System.out.write(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                try {
                    System.out.write(errorResponse);
                } catch (IOException k) {
                    Log.e("MYAPP", "unexpected JSON exception", k);
                }
                System.out.println(Arrays.toString(errorResponse));
                Log.e("ke", "SDds", e);

            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
                Log.d("ke", "retry");
            }
        });
    }

}