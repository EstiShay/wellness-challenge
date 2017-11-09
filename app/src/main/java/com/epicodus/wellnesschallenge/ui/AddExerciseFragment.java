package com.epicodus.wellnesschallenge.ui;


import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epicodus.wellnesschallenge.Constants;
import com.epicodus.wellnesschallenge.R;
import com.epicodus.wellnesschallenge.models.Exercise;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddExerciseFragment extends DialogFragment implements View.OnClickListener {
    @Bind(R.id.exerciseTypeEditText) EditText mExerciseTypeEditText;
    @Bind(R.id.dateEditText) EditText mDateEditText;
    @Bind(R.id.milesEditText) EditText mMilesEditText;
    @Bind(R.id.cancelButton) Button mCancelButton;
    @Bind(R.id.saveButton) Button mSaveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_exercise, container, false);
        getDialog().setTitle("Exercise Form Dialog");
        ButterKnife.bind(this, rootView);

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        mCancelButton.setOnClickListener(this);
        mSaveButton.setOnClickListener(this);
        return rootView;
    }
    @Override
    public void onClick(View v){
        if (v == mSaveButton){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();
            String exerciseType = mExerciseTypeEditText.getText().toString().trim();
            String date = mDateEditText.getText().toString().trim();
            double miles = Double.parseDouble(mMilesEditText.getText().toString());
            Exercise mExercise = new Exercise(date, exerciseType, miles);
            DatabaseReference exerciseRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_EXERCISES)
                    .child(uid);
            DatabaseReference pushRef = exerciseRef.push();
            String pushId = pushRef.getKey();
            mExercise.setPushId(pushId);
            pushRef.setValue(mExercise);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
            dismiss();
        } else if (v == mCancelButton){
            dismiss();
        }
    }
}
