package com.epicodus.wellnesschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.teamButton) Button mTeamButton;
    @Bind(R.id.dashButton) Button mDashButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);


        mTeamButton.setOnClickListener(this);
        mDashButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mDashButton) {
            Intent intent = new Intent(InfoActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
