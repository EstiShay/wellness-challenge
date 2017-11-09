package com.epicodus.wellnesschallenge.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.wellnesschallenge.R;
import com.epicodus.wellnesschallenge.models.Exercise;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.ExerciseViewHolder> {
    private ArrayList<Exercise> mExercises = new ArrayList<>();
    private Context mContext;

    public ExerciseListAdapter(Context context, ArrayList<Exercise> exercises) {
        mContext = context;
        mExercises = exercises;
    }

    @Override
    public ExerciseListAdapter.ExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_list_item, parent, false);
        ExerciseViewHolder viewHolder = new ExerciseViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ExerciseListAdapter.ExerciseViewHolder holder, int position) {
        holder.bindExercise(mExercises.get(position));
    }

    @Override
    public int getItemCount() {
        return mExercises.size();
    }

    public class ExerciseViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.dateTextView) TextView mDateTextView;
        @Bind(R.id.milesTextView) TextView mMilesTextView;
        private Context mContext;

        public ExerciseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindExercise(Exercise exercise) {
            mDateTextView.setText(exercise.getDate());
            String doubleString = Double.toString(exercise.getMiles());
            mMilesTextView.setText(doubleString);
        }
    }
}
