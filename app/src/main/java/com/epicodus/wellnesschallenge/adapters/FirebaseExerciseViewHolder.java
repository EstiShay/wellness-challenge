package com.epicodus.wellnesschallenge.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.wellnesschallenge.R;
import com.epicodus.wellnesschallenge.models.Exercise;



public class FirebaseExerciseViewHolder extends RecyclerView.ViewHolder{

    View mView;
    Context mContext;

    public FirebaseExerciseViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindExercise(Exercise exercise){
        TextView dateTextView = (TextView) mView.findViewById(R.id.dateTextView);
        TextView milesTextView = (TextView) mView.findViewById(R.id.milesTextView);
        ImageView mExerciseImageView = (ImageView) mView.findViewById(R.id.exerciseImageView);

        dateTextView.setText(exercise.getDate());
        String milesString = Double.toString(exercise.getMiles());
        milesTextView.setText(milesString);
        String foundExercise = exercise.getExerciseType();
        if (foundExercise.equals("Bicycle")){
            mExerciseImageView.setImageResource(R.drawable.ic_bike_black);
        } else if (foundExercise.equals("Run")){
            mExerciseImageView.setImageResource(R.drawable.ic_run_black);
        } else if (foundExercise.equals("Walk")){
            mExerciseImageView.setImageResource(R.drawable.ic_walk_black);
        }


    }
}
