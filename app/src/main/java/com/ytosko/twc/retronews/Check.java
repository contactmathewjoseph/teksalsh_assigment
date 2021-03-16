package com.ytosko.twc.retronews;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class Check extends AppCompatActivity {
    FirebaseAuth mAuth;
    private ProgressDialog pDialog;
    final Handler handler = new Handler();
    int x;
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);


        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        ActionBar a = getSupportActionBar();
        a.hide();

        x = 3;
        pDialog = new ProgressDialog(Check.this);
        pDialog.setTitle("Welcome");
        pDialog.setMessage("Please wait while you are being verified");
        pDialog.setCancelable(false);
        pDialog.show();

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser()!=null){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            boolean emailVerified = user.isEmailVerified();
            if(emailVerified){
                Intent intToHome = new Intent(Check.this, profile.class);
                intToHome.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intToHome);
                finish();

            }
            else if(!emailVerified)
            {

                FirebaseAuth.getInstance().signOut();

                Intent intToHome = new Intent(Check.this, login.class);
                intToHome.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intToHome);
                finish();

            }
        }
        else{
                Intent intToHome = new Intent(Check.this, login.class);
                intToHome.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intToHome);
                finish();

        }

    }


}

