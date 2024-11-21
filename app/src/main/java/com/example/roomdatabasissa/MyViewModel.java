package com.example.roomdatabasissa;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    private MyRepository repository;

    // Constructor
    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new MyRepository(application);  // إنشاء الكائن من MyRepository
    }

    // Insert a course
    public void insertCourse(Course course) {
        repository.insertCourse(course);
    }

    // Update a course
    public void updateCourse(Course course) {
        repository.updateCourse(course);
    }

    // Delete a course
    public void deleteCourse(Course course) {
        repository.deleteCourse(course);
    }

    // Get all courses as LiveData
    public LiveData<List<Course>> getAllCourse() {
        return repository.getAllCourse();
    }

    // Get a course by its ID
    public LiveData<List<Course>> getAllCourseById(int courseId) {
        return repository.getAllCourseById(courseId);
    }

    // Insert a student
    public void insertStudent(Student student) {
        repository.insertStudent(student);
    }

    // Update a student
    public void updateStudent(Student student) {
        repository.updateStudent(student);
    }

    // Delete a student
    public void deleteStudent(Student student) {
        repository.deleteStudent(student);
    }

    // Get all students as LiveData
    public LiveData<List<Student>> getAllStudent() {
        return repository.getAllStudent();
    }

    // Get students by course ID as LiveData
    public LiveData<List<Student>> getAllStudentCourseId(int courseId) {
        return repository.getAllStudentCourseId(courseId);
    }
}
