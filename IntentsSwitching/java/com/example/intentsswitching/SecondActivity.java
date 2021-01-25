package com.example.intentsswitching;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button btn;
    private TextView text;
    private static String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn = findViewById(R.id.button1);
        text =(TextView) findViewById(R.id.text1);
        Intent intent = getIntent();
        str = intent.getStringExtra(MainActivity.str );
        text.setText(str);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search = searchWeb( v );
                startActivity(search);
            }
        });
    }
    public Intent searchWeb(View view){
        Uri uri = Uri.parse("https://www.google.com/search?q="+str);
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        return i;
    }
}
