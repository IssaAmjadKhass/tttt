package com.example.roomdatabasissa;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface CourseDao {

    @Insert
    void insertCourse(Course course);

    @Update
    void updateCourse(Course course);

    @Delete
    void deleteCourse(Course course);

    @Query("SELECT * FROM course") // تأكد من أن اسم الجدول هو "course" وليس "courses"
    LiveData<List<Course>> getAllCourse();

    @Query("SELECT * FROM course WHERE id = :courseId") // تأكد من أن اسم الجدول هنا هو "course"
    LiveData<List<Course>> getAllCourseById(int courseId);
}


