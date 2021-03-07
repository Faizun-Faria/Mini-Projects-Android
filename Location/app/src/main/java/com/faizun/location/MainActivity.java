package com.faizun.location;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);

        mQueue = Volley.newRequestQueue(this);
        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });

    }

    private void jsonParse() {
        String url = "http://anontech.info/courses/cse491/employees.json";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            try {
                Log.v("error",""+response.length());

                for(int i=0; i<response.length();i++){
                    JSONObject jsonObject = response.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    if(jsonObject.getString("location")=="null"){
                        mTextViewResult.append(name+ ", "+ jsonObject.getString("location")+"\n\n");

                    }else{
                        double lat = jsonObject.getJSONObject("location").getDouble("latitude");
                        double lon = jsonObject.getJSONObject("location").getDouble("longitude");

                        mTextViewResult.append(name+ ", "+ lat +", "+ lon +"\n\n");
                    }

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> error.printStackTrace());
    mQueue.add(request);
    }
}
