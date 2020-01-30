package com.example.wallpaper.ui.main.password;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.wallpaper.R;
import com.example.wallpaper.ui.main.ActivityWallpaper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityPassword extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    public static String userId="";

    private EditText password, email;
    private Button bt_v, bt_r;

    private Toolbar toolbar;
    private ActionBar bar;
    private SharedPreferences preferences;
    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwors);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        bt_v = findViewById(R.id.bt_v);
        bt_r = findViewById(R.id.bt_r);

        toolbar = findViewById(R.id.toolPassword);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bar = getSupportActionBar();
        bar.setTitle("Password");

        mAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Intent intent = new Intent(ActivityPassword.this, ActivityWallpaper.class);
                    startActivity(intent);
                }
            }
        };

            bt_v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveText();
                    Signing(email.getText().toString(),password.getText().toString());
                }

                private void saveText() {
                    preferences = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(SAVED_TEXT, bt_v.getText().toString());
                    editor.commit();
                    Toast.makeText(ActivityPassword.this, "Text save", Toast.LENGTH_LONG).show();
                }
            });

            bt_r.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Registration(email.getText().toString(),password.getText().toString());
                }
            });

        }
    private void Signing(final String email, String password){
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    userId = mAuth.getCurrentUser().getUid();
                    Toast.makeText(ActivityPassword.this, "Авторизация успешна", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(ActivityPassword.this, "Авторизация провалена", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void Registration(final String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ActivityPassword.this, "Регистрация успешна", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ActivityPassword.this, "Регистрация провалена", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
