package com.ytosko.twc.retronews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class newspaper extends AppCompatActivity {

    CheckBox star, alo, proti, desh, juga, kontho, faq, kal, diga, today, sun;
    LinearLayout lp, set;
    DatabaseReference myref, iref;
    String x;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newspaper);

        ActionBar a = getSupportActionBar();
        a.hide();
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        star = findViewById(R.id.star);
        alo = findViewById(R.id.alo);
        proti = findViewById(R.id.prati);
        juga = findViewById(R.id.jugantor);
        kontho = findViewById(R.id.kontho);
        faq = findViewById(R.id.ittefuq);
        kal = findViewById(R.id.samakal);
        diga = findViewById(R.id.digonto);
        today = findViewById(R.id.btoday);
        sun = findViewById(R.id.sun);

        set = findViewById(R.id.set);

        lp = findViewById(R.id.lp123);

        myref = FirebaseDatabase.getInstance().getReference("papers");
        iref = myref.child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        iref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    dataSnapshot.getRef().removeValue();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        pDialog = new ProgressDialog(newspaper.this);
        pDialog.setCancelable(false);
        pDialog.setTitle("Updating");
        pDialog.setMessage("Please wait");

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalamount=1;
                if(star.isChecked()){
                    pDialog.show();
                    iref.child("paper " + totalamount).child("name").setValue("The Daily Star");
                    iref.child("paper " + totalamount).child("link").setValue("https://www.thedailystar.net/");
                    totalamount++;
                }
                if(alo.isChecked()){
                    iref.child("paper " + totalamount).child("name").setValue("Prothom Alo");
                    iref.child("paper " + totalamount).child("link").setValue("https://www.prothomalo.com/");
                    totalamount++;
                }
                if(proti.isChecked()){
                    iref.child("paper " + totalamount).child("name").setValue("Bangladesh Pratidin");
                    iref.child("paper " + totalamount).child("link").setValue("www.bd-pratidin.com");
                    totalamount++;
                }
                if(juga.isChecked()){
                    iref.child("paper " + totalamount).child("name").setValue("Jugantor");
                    iref.child("paper " + totalamount).child("link").setValue("https://www.jugantor.com/");
                    totalamount++;
                }
                if(kontho.isChecked()){
                    iref.child("paper " + totalamount).child("name").setValue("Kaler Kontho");
                    iref.child("paper " + totalamount).child("link").setValue("https://www.kalerkantho.com/");
                    totalamount++;
                } if(faq.isChecked()){
                    iref.child("paper " + totalamount).child("name").setValue("Ittefaq");
                    iref.child("paper " + totalamount).child("link").setValue("https://www.ittefaq.com.bd/");
                    totalamount++;
                }
                if(kal.isChecked()){
                    iref.child("paper " + totalamount).child("name").setValue("Samakal");
                    iref.child("paper " + totalamount).child("link").setValue("https://www.samakal.com");
                    totalamount++;
                }
                if(diga.isChecked()){
                    iref.child("paper " + totalamount).child("name").setValue("Naya Diganta");
                    iref.child("paper " + totalamount).child("link").setValue("https://www.dailynayadiganta.com/");
                    totalamount++;
                }
                if(today.isChecked()){
                    iref.child("paper " + totalamount).child("name").setValue("BD News 24");
                    iref.child("paper " + totalamount).child("link").setValue("http://bdnews24.com/");
                    totalamount++;
                }
                if(sun.isChecked()){
                    iref.child("paper " + totalamount).child("name").setValue("The Daily Sun");
                    iref.child("paper " + totalamount).child("link").setValue("https://www.daily-sun.com/");
                    totalamount++;
                }
                pDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Newspaper lidt updated", Toast.LENGTH_LONG).show();
                Intent intToHome = new Intent(newspaper.this, profile.class);
                intToHome.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intToHome);
                finish();
            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            onBackPressed();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intToHome = new Intent(newspaper.this, profile.class);
        intToHome.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intToHome);
        finish();

    }
}
