package com.example.roomdatabasissa;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabasissa.Course;
import com.example.roomdatabasissa.MyRepository;
import com.example.roomdatabasissa.R;

import java.util.List;

public class Rec_Room extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rec_room);

        recyclerView = findViewById(R.id.recycler); // Correctly initialize RecyclerView
        MyRepository myRepository = new MyRepository(getApplication());

        // Fetch all courses from the repository
        LiveData<List<Course>> coursses = myRepository.getAllCourse();

        // Set up the RecyclerView and adapter
        RoomAdapter roomAdapter = new RoomAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(roomAdapter);

        // Observe LiveData to update the adapter when data changes
        coursses.observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(List<Course> courss) {
                roomAdapter.setCourses(courss);  // Update adapter with new data
            }
        });
    }
}
