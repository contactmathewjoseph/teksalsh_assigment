package com.ytosko.twc.retronews;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.ActionBar;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class MainActivity extends AwesomeSplash {

    @Override
    public void initSplash ( ConfigSplash configSplash ) {

        ActionBar a = getSupportActionBar();
        a.hide();
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        configSplash.setBackgroundColor(R.color.Wheat);
        configSplash.setAnimLogoSplashDuration( 3000 );
        configSplash.setRevealFlagX( Flags.REVEAL_RIGHT );
        configSplash.setRevealFlagX( Flags.REVEAL_TOP );
        configSplash.setLogoSplash( R.drawable.ic_blood_hub_01_101);
        configSplash.setAnimLogoSplashDuration( 3000 );
        configSplash.setPathSplash("");
        configSplash.setAnimLogoSplashTechnique( Techniques.Flash );

        configSplash.setTitleSplash("By Ytosko");
        configSplash.setTitleTextColor(R.color.colorPrimary);
        configSplash.setTitleTextSize(30f);
        configSplash.setAnimTitleDuration(3000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);

    }

    @Override
    public void animationsFinished () {
        startActivity( new Intent( MainActivity.this , Check.class) );
        finish();

    }
}