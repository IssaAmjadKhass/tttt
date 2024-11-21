package com.example.roomdatabasissa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.roomdatabasissa.Course;
import com.example.roomdatabasissa.MyViewModel;
import com.example.roomdatabasissa.R;

public class MainActivity extends AppCompatActivity {

    Button camera, insert, AddRec;
    Bitmap bitmap;

    // ActivityResultLauncher for handling camera intent
    ActivityResultLauncher<Intent> cameraActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        bitmap = (Bitmap) result.getData().getExtras().get("data");
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewModel
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        // Initialize buttons with findViewById
        camera = findViewById(R.id.CAMERS); // Fix: Assign to the 'camera' variable
        insert = findViewById(R.id.AddImj); // Fix: Assign to the 'insert' variable
        AddRec = findViewById(R.id.AddRec); // Fix: Assign to the 'AddRec' variable

        // Set onClick listener for AddRec button
        AddRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Rec_Room.class);
                startActivity(intent);
            }
        });

        // Set onClick listener for camera button
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraActivity.launch(intent);
            }
        });

        // Set onClick listener for insert button
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.insertCourse(new Course("java", 35));
                myViewModel.insertCourse(new Course("android", 45));
                myViewModel.insertCourse(new Course("css", 20));
            }
        });
    }
}

