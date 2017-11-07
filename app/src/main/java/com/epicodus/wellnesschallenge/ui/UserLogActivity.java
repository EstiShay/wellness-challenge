package com.epicodus.wellnesschallenge.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.epicodus.wellnesschallenge.MainActivity;
import com.epicodus.wellnesschallenge.R;
import com.epicodus.wellnesschallenge.adapters.ExerciseListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserLogActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.dashButton) Button mDashButton;
    @Bind(R.id.infoButton) Button mInfoButton;
    @Bind(R.id.teamButton) Button mTeamButton;
    @Bind(R.id.addButton) Button mAddButton;
    @Bind(R.id.userLogsRecyclerView) RecyclerView mRecyclerView;
    private ExerciseListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_log);
        ButterKnife.bind(this);

        mDashButton.setOnClickListener(this);
        mInfoButton.setOnClickListener(this);

        getExercises();
    }

    public void getExercises(){

    }

    @Override
    public void onClick(View v) {
        if (v == mInfoButton) {
            Intent intent = new Intent(UserLogActivity.this, InfoActivity.class);
            startActivity(intent);
        } else if (v == mDashButton) {
            Intent intent = new Intent(UserLogActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
