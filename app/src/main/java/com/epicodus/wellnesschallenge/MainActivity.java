package com.epicodus.wellnesschallenge;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.wellnesschallenge.ui.AddExerciseFragment;
import com.epicodus.wellnesschallenge.ui.InfoActivity;
import com.epicodus.wellnesschallenge.ui.LoginActivity;
import com.epicodus.wellnesschallenge.ui.UserLogActivity;
import com.google.firebase.auth.FirebaseAuth;

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
            Intent intent = new Intent(MainActivity.this, UserLogActivity.class);
            startActivity(intent);
        } else if (v == mAddButton) {
            AddExerciseFragment addExerciseFragment = new AddExerciseFragment();
            addExerciseFragment.show(getSupportFragmentManager(), "Exercise Form Dialog");
        } else if (v == mTeamButton) {

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
