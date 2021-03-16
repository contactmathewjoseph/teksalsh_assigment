package com.ytosko.twc.retronews;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androdocs.httprequest.HttpRequest;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class profile extends AppCompatActivity implements LocationListener {
    LinearLayout lp1, lp2, lp3,lp4,lp6;
    Button lp5;
    ImageView weatherview, newsview, profileview;
    String API = "bd4add5d8d966feb75ed3216bb713d53";
    LocationManager locationManager;
    double log, lat;
    Button update, out;
    TextView name, name1, email;
    ImageView dp;
    LocationManager loc;
    TextView addressTxt, updated_atTxt, statusTxt, tempTxt, temp_minTxt, temp_maxTxt, sunriseTxt,
            sunsetTxt, windTxt, pressureTxt, humidityTxt;
    String fullname;
    String Check = null;
    TextView t1,t2,t3;
    private ProgressDialog dialog;

    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(1);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_profile);
        ActionBar a = getSupportActionBar();
        a.hide();
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        weatherview = findViewById(R.id.weat);
        newsview = findViewById(R.id.news);
        profileview = findViewById(R.id.prof);
        lp1 = findViewById(R.id.weatherx);

        addressTxt = findViewById(R.id.address);
        updated_atTxt = findViewById(R.id.updated_at);
        statusTxt = findViewById(R.id.status);
        tempTxt = findViewById(R.id.temp);
        temp_minTxt = findViewById(R.id.temp_min);
        temp_maxTxt = findViewById(R.id.temp_max);
        sunriseTxt = findViewById(R.id.sunrise);
        sunsetTxt = findViewById(R.id.sunset);
        windTxt = findViewById(R.id.wind);
        pressureTxt = findViewById(R.id.pressure);
        humidityTxt = findViewById(R.id.humidity);

        lp4 = findViewById(R.id.reweather);
        lp2 = findViewById(R.id.profilex);
        lp5 = findViewById(R.id.maga);
        lp3 = findViewById(R.id.newsx);
        lp6 = findViewById(R.id.lp_link);

        name = findViewById(R.id.nameof);
        name1 = findViewById(R.id.nameof1);
        email = findViewById(R.id.emailof);
        dp = findViewById(R.id.dp);

        update =  findViewById(R.id.upd);
        out = findViewById(R.id.out);

        dialog = new ProgressDialog(profile.this);
        dialog.setTitle("Loading data");
        dialog.setCancelable(false);
        dialog.setMessage("Please wait");

        dialog.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                dialog.dismiss();
            }
        }, 2000);

        lp6.setPadding(20,0,20,0);
        final DatabaseReference myref = FirebaseDatabase.getInstance().getReference().child("papers").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        // Toast.makeText(profile.this, FirebaseAuth.getInstance().getCurrentUser().getUid(), Toast.LENGTH_SHORT).show();
        myref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                newshelper os = dataSnapshot.getValue(newshelper.class);
                myref.keepSynced(true);
                final String name = os.getName();
                final DatabaseReference iref = FirebaseDatabase.getInstance().getReference().child(name);

                iref.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot1, @Nullable String s) {
                        final urlhelper osx = dataSnapshot1.getValue(urlhelper.class);
                        iref.keepSynced(true);
                        t1 = new TextView(profile.this);
                        t1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
                        t1.setTextColor(Color.WHITE);
                        t1.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                        t1.setTypeface(Typeface.MONOSPACE);
                        final LinearLayout.LayoutParams lp20 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        t1.setPadding(10,40,10, 10);
                        t1.setLayoutParams(lp20);
                        t1.setText(name);
                        t1.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
                        lp6.addView(t1);

                        if(Check != null && Check.equals(name)){
                            t1.setVisibility(View.GONE);
                        }

                        Check = name;

                        t2 = new TextView(profile.this);
                        t2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
                        t2.setTextColor(Color.YELLOW);
                        t2.setGravity(Gravity.LEFT);
                        t2.setTypeface(Typeface.SANS_SERIF);
                        t2.setPadding(10,40,10, 40);
                        t2.setLayoutParams(lp20);
                        t2.setText(osx.getTitle());
                        t2.setClickable(true);
                        t2.setFocusable(true);
                        lp6.addView(t2);

                        t3 = new TextView(profile.this);
                        t3.setLayoutParams(new LinearLayout.LayoutParams(
                                WindowManager.LayoutParams.MATCH_PARENT,
                                2
                        ));
                        t3.setPadding(0, 30,0,0);
                        t3.setBackgroundResource(R.color.primaryTextColor);
                        lp6.addView(t3);

                        t2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String ur = osx.getUrl();
                                Intent i = new Intent(profile.this, newsreader.class);
                                i.putExtra("key", ur);
                                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(i);
                            }
                        });

                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        profileview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lp2.setVisibility(View.VISIBLE);
                lp1.setVisibility(View.GONE);
                lp3.setVisibility(View.GONE);
            }
        });
        lp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(profile.this, newspaper.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
                finish();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(profile.this, EditProfile.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
                finish();
            }
        });

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(profile.this, login.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
                finish();
            }
        });

        newsview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lp1.setVisibility(View.GONE);
                lp2.setVisibility(View.GONE);
                lp3.setVisibility(View.VISIBLE);
            }
        });

        loc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        final int REQUEST_CODE_ASK_PERMISSIONS = 123;
        if ( Build.VERSION.SDK_INT >= 23){
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED  ){
                requestPermissions(new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return ;
            }
        }

        DatabaseReference iref =  FirebaseDatabase.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        iref.keepSynced(true);

        iref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                fullname = dataSnapshot.child("fname").getValue(String.class) + " "  + dataSnapshot.child("lname").getValue(String.class);
                name.setText(fullname);
                name1.setText(fullname);
                email.setText(dataSnapshot.child("email").getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user.getPhotoUrl() != null) {
            Glide.with(this)
                    .load(user.getPhotoUrl())
                    .into(dp);
        }



        Location location = loc.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        onLocationChanged(location);

        new profile.weatherTask().execute();

        lp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new profile.weatherTask().execute();
                Toast.makeText(profile.this, "Location has been updated", Toast.LENGTH_SHORT).show();
            }
        });

        weatherview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lp1.setVisibility(View.VISIBLE);
                lp2.setVisibility(View.GONE);
                lp3.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {

        if(location!= null){
            lat = location.getLatitude();
            log = location.getLongitude();
        }
        Log.e("names : ", log + " " + lat);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    class weatherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            findViewById(R.id.loader).setVisibility(View.VISIBLE);
            findViewById(R.id.mainContainer).setVisibility(View.GONE);
            findViewById(R.id.errorText).setVisibility(View.GONE);
        }

        protected String doInBackground(String... args) {
            String response = HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + log + "&units=metric&appid=" + API);
            return response;
        }

        @Override
        protected void onPostExecute(String result) {

            super.onPostExecute(result);

            if(result!=null){

            try {
                JSONObject jsonObj = new JSONObject(result);
                JSONObject main = jsonObj.getJSONObject("main");
                JSONObject sys = jsonObj.getJSONObject("sys");
                JSONObject wind = jsonObj.getJSONObject("wind");
                JSONObject weather = jsonObj.getJSONArray("weather").getJSONObject(0);

                Long updatedAt = jsonObj.getLong("dt");
                String updatedAtText = "Updated on : " + new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date(updatedAt * 1000));
                String temp = main.getString("temp") + "°C";
                String tempMin = "Min Temp: " + main.getString("temp_min") + "°C";
                String tempMax = "Max Temp: " + main.getString("temp_max") + "°C";
                String pressure = main.getString("pressure");
                String humidity = main.getString("humidity");

                Long sunrise = sys.getLong("sunrise");
                Long sunset = sys.getLong("sunset");
                String windSpeed = wind.getString("speed");
                String weatherDescription = weather.getString("description");

                String address = jsonObj.getString("name") + ", " + sys.getString("country");

                addressTxt.setText(address);
                updated_atTxt.setText(updatedAtText);
                statusTxt.setText(weatherDescription.toUpperCase());
                tempTxt.setText(temp);
                temp_minTxt.setText(tempMin);
                temp_maxTxt.setText(tempMax);
                sunriseTxt.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunrise * 1000)));
                sunsetTxt.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunset * 1000)));
                windTxt.setText(windSpeed);
                pressureTxt.setText(pressure);
                humidityTxt.setText(humidity);

                /* Views populated, Hiding the loader, Showing the main design */
                findViewById(R.id.loader).setVisibility(View.GONE);
                findViewById(R.id.mainContainer).setVisibility(View.VISIBLE);


            } catch (JSONException e) {
                findViewById(R.id.loader).setVisibility(View.GONE);
                findViewById(R.id.errorText).setVisibility(View.VISIBLE);
                Toast.makeText(profile.this, "Please wait while loading", Toast.LENGTH_SHORT).show();
            }
        }

        }
    }


}
