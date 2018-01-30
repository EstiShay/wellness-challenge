package com.epicodus.wellnesschallenge.ui;


import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class AddExerciseFragment extends DialogFragment implements View.OnClickListener,
        AdapterView.OnItemSelectedListener {
    @Bind(R.id.exercisesSpinner) Spinner mExercisesSpinner;
    @Bind(R.id.dateEditText) EditText mDateEditText;
    @Bind(R.id.milesEditText) EditText mMilesEditText;
    //@Bind(R.id.cancelButton) Button mCancelButton;
    @Bind(R.id.saveButton) Button mSaveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_exercise, container, false);
        getDialog().setTitle("Exercise Form Dialog");
        ButterKnife.bind(this, rootView);

        //mCancelButton.setOnClickListener(this);
        mSaveButton.setOnClickListener(this);

        //Spinner element
        Spinner spinner = (Spinner) rootView.findViewById(R.id.exercisesSpinner);
        //Spinner click listener
        spinner.setOnItemSelectedListener(this);
        //Create adapter for listener
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array
                .exercises_array, android.R.layout.simple_spinner_item);
        //Set drop down layout style
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Attach adapter to spinner
        spinner.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        String item = parent.getItemAtPosition(pos).toString();
    }
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(parent.getContext(), "Please select an exercise option", Toast
                .LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v){
        if (v == mSaveButton){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();
            String exerciseType = mExercisesSpinner.toString().trim();
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
        //} else if (v == mCancelButton){
           // dismiss();
        }
    }

}
