package com.epicodus.wellnesschallenge;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.wellnesschallenge.ui.InfoActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Bind(R.id.subtitleTextView) TextView mSubtitleTextView;
    @Bind(R.id.addButton) Button mAddButton;
    @Bind(R.id.myLogButton) Button mMyLogButton;
    @Bind(R.id.teamButton) Button mTeamButton;
    @Bind(R.id.infoButton) Button mInfoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface ranchoFont = Typeface.createFromAsset(getAssets(), "fonts/rancho.ttf");
        mAppNameTextView.setTypeface(ranchoFont);
        Typeface commeFont = Typeface.createFromAsset(getAssets(), "fonts/commeregular.ttf");
        mSubtitleTextView.setTypeface(commeFont);

        mAddButton.setOnClickListener(this);
        mMyLogButton.setOnClickListener(this);
        mTeamButton.setOnClickListener(this);
        mInfoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mInfoButton) {
            Intent intent = new Intent(MainActivity.this, InfoActivity.class);
            startActivity(intent);
        } else if (v == mMyLogButton) {

        } else if (v == mTeamButton) {

        } else if (v == mAddButton) {

        }
    }
}
