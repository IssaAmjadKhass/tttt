package com.example.roomdatabasissa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabasissa.Course;
import com.example.roomdatabasissa.R;

import java.util.ArrayList;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.MyHolder> {

    Context context;
    List<Course> courseList;  // Hold the course data

    public RoomAdapter(Context context) {
        this.context = context;
        this.courseList = new ArrayList<>();
    }

    // Update the course list and notify the adapter
    public void setCourses(List<Course> courses) {
        this.courseList = courses;
        notifyDataSetChanged();  // Notify adapter that the data has changed
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_room, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Course courss = courseList.get(position);  // Get the course at the current position

        // Set the data for each item in the RecyclerView
        holder.course.setText(courss.getCourseName());
        holder.student.setText(String.valueOf(courss.getNoOfStudent()));
    }

    @Override
    public int getItemCount() {
        return courseList.size();  // Return the number of items in the list
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView student, course;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            student = itemView.findViewById(R.id.Student);  // Bind the "student" TextView
            course = itemView.findViewById(R.id.course);    // Bind the "course" TextView
        }
    }
}
