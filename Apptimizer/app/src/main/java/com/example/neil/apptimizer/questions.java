package com.example.neil.apptimizer;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;

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

    // Overriding onTouchEvent to test user IO
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        AsyncHttpClient client = new AsyncHttpClient();
        JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("Asas", "2323");
        } catch (JSONException e) {
            Log.e("MYAPP", "unexpected JSON exception", e);
        }
        HttpEntity entity = new HttpEntity() {
            @Override
            public boolean isRepeatable() {
                return false;
            }

            @Override
            public boolean isChunked() {
                return false;
            }

            @Override
            public long getContentLength() {
                return 0;
            }

            @Override
            public Header getContentType() {
                return null;
            }

            @Override
            public Header getContentEncoding() {
                return null;
            }

            @Override
            public InputStream getContent() throws IOException, IllegalStateException {
                return null;
            }

            @Override
            public void writeTo(OutputStream outstream) throws IOException {

            }

            @Override
            public boolean isStreaming() {
                return false;
            }

            @Override
            public void consumeContent() throws IOException {

            }
        };
        client.post(null, "http://arashrai.com:5000/hack", entity, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                // called before request is started
                Log.d("ke", "onStart");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                Log.d("ke", "success");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Log.d("ke", errorResponse.toString());

            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
                Log.d("ke", "retry");
            }
        });

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
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }




}