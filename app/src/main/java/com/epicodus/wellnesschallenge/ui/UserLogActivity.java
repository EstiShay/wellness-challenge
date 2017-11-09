package com.epicodus.wellnesschallenge.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.epicodus.wellnesschallenge.Constants;
import com.epicodus.wellnesschallenge.MainActivity;
import com.epicodus.wellnesschallenge.R;
import com.epicodus.wellnesschallenge.adapters.ExerciseListAdapter;
import com.epicodus.wellnesschallenge.adapters.FirebaseExerciseViewHolder;
import com.epicodus.wellnesschallenge.models.Exercise;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserLogActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.dashButton) Button mDashButton;
    @Bind(R.id.infoButton) Button mInfoButton;
    @Bind(R.id.teamButton) Button mTeamButton;
    @Bind(R.id.addButton) Button mAddButton;
    @Bind(R.id.userLogsRecyclerView) RecyclerView mRecyclerView;
    private ExerciseListAdapter mAdapter;
    private DatabaseReference mExercisesReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_log);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mDashButton.setOnClickListener(this);
        mInfoButton.setOnClickListener(this);
        mAddButton.setOnClickListener(this);
        mTeamButton.setOnClickListener(this);

        mExercisesReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_EXERCISES).child(uid);
        setUpFirebaseAdapter();
    }

    public void setUpFirebaseAdapter(){
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Exercise, FirebaseExerciseViewHolder>(Exercise.class, R.layout.exercise_list_item, FirebaseExerciseViewHolder.class, mExercisesReference) {
            @Override
            protected void populateViewHolder(FirebaseExerciseViewHolder viewHolder, Exercise model, int position) {
                viewHolder.bindExercise(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

    @Override
    public void onClick(View v) {
        if (v == mInfoButton) {
            Intent intent = new Intent(UserLogActivity.this, InfoActivity.class);
            startActivity(intent);
        } else if (v == mDashButton) {
            Intent intent = new Intent(UserLogActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (v == mTeamButton){
                Toast.makeText(UserLogActivity.this, "Coming soon!", Toast.LENGTH_SHORT).show();
        } else if (v == mAddButton){
            AddExerciseFragment addExerciseFragment = new AddExerciseFragment();
            addExerciseFragment.show(getSupportFragmentManager(), "Exercise Form Dialog");
        }
    }
}
