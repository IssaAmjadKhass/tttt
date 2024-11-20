package com.example.roomdatabasissa;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    MyRepository repository ;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new MyRepository(application);


    }
    public void insertCourse(Course course){

        repository.insertCourse(course);

    }

    void updateCourse (Course courss){

        repository.updateCourse(courss);

    }


    void deleteCourse(Course courss){

        repository.deleteCourse(courss);

    }


    LiveData<List<Course>> getAllCourse(){
        return repository.getAllCourse();
    }
    LiveData<List<Course>> getAllCourseById(int courseId){
        return repository.getAllCourseById(courseId);
    }



    void insertStudent (Student student){
        repository.insertStudent(student);

    }


    void updateStudent (Student student){

        repository.updateStudent(student);

    }


    void deleteStudent(Student student){

        repository.deleteStudent(student);

    }


    LiveData<List<Student>> getAllStudent (){
        return repository.getAllStudent();
    }

    LiveData<List<Student>> getAllStudentCourseId(int courseId){
        return repository.getAllStudentCourseId(courseId);
    }
}
