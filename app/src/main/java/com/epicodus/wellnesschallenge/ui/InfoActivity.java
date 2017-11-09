package com.epicodus.wellnesschallenge.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.wellnesschallenge.MainActivity;
import com.epicodus.wellnesschallenge.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Bind(R.id.aboutTextView) TextView mAboutTextView;
    @Bind(R.id.teamButton) Button mTeamButton;
    @Bind(R.id.dashButton) Button mDashButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);

        Typeface ranchoFont = Typeface.createFromAsset(getAssets(), "fonts/rancho.ttf");
        mAppNameTextView.setTypeface(ranchoFont);
        Typeface commeFont = Typeface.createFromAsset(getAssets(), "fonts/commeregular.ttf");
        mAboutTextView.setTypeface(commeFont);

        mTeamButton.setOnClickListener(this);
        mDashButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mDashButton) {
            Intent intent = new Intent(InfoActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (v == mTeamButton) {
            Toast.makeText(InfoActivity.this, "Coming soon!", Toast.LENGTH_SHORT).show();
        }
    }
}
