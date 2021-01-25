package com.example.assistant;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class DashboradActivity extends AppCompatActivity {
    Button logoutButton;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        final String email = getIntent().getStringExtra("email");
        final String studentId = getIntent().getStringExtra("studentId");
        ((TextView)findViewById(R.id.emailtext)).setText("Logged in via: " + email);
        ((TextView)findViewById(R.id.emailtext)).setText("your student ID :"+studentId);


        logoutButton = findViewById(R.id.button_logout);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signoutFromGoogle();
    }

    private void signoutFromGoogle() {
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task<Void> voidTask = mGoogleSignInClient.signOut();
                voidTask.addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        finish();
                        Toast.makeText(getApplicationContext(), "Log out successful", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
