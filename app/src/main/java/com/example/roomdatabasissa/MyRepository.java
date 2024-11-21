package com.example.roomdatabasissa;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyRepository {
    private StudentDao studentDao;
    private CourseDao courseDao;

    public MyRepository(Application application) {
        DataBas db = DataBas.getDatabase(application);
        studentDao = db.studentDao();
        courseDao = db.courseDao();
    }

    void insertCourse (Course course){
        DataBas.databaseWriteExecutor.execute(()-> {
            courseDao.insertCourse(course);
        });
    }

    void updateCourse (Course course){
        DataBas.databaseWriteExecutor.execute(()->{
            courseDao.updateCourse(course);
        });
    }


    void deleteCourse(Course course){
        DataBas.databaseWriteExecutor.execute(()->{
            courseDao.deleteCourse(course);
        });
    }


    public LiveData<List<Course>> getAllCourse(){
        return courseDao.getAllCourse();
    }
    LiveData<List<Course>> getAllCourseById(int courseId){
        return courseDao.getAllCourseById(courseId);
    }



    void insertStudent (Student student){
        DataBas.databaseWriteExecutor.execute(()->{
            studentDao.insertStudent(student);
        });
    }


    void updateStudent (Student student){
        DataBas.databaseWriteExecutor.execute(()->{
            studentDao.updateStudent(student);
        });
    }


    void deleteStudent(Student student){
        DataBas.databaseWriteExecutor.execute(()->{
            studentDao.deleteStudent(student);
        });
    }


    LiveData<List<Student>> getAllStudent (){
        return studentDao.getAllStudent();
    }

    LiveData<List<Student>> getAllStudentCourseId(int courseId){
        return studentDao.getAllStudentCourseId(courseId);
    }
}
