package com.epicodus.wellnesschallenge.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

        dateTextView.setText(exercise.getDate());
        String milesString = Double.toString(exercise.getMiles());
        milesTextView.setText(milesString);


    }
}
