package com.example.roomdatabasissa;

import android.graphics.Bitmap;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(
        foreignKeys = @ForeignKey(
                entity = Course.class,     // The entity we are referencing (Course)
                parentColumns = "id",      // The column in the Course table (primary key)
                childColumns = "courseId"  // The column in the Student table that will hold the foreign key
        )
)
@TypeConverters(Converter.class)  // Converters for non-standard types (Bitmap, Date, etc.)
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String department;
    private Bitmap photo;  // Bitmap will be converted to byte[]
    private Date dateOfBirth;  // Date will be converted to Long
    private int courseId;  // Foreign key column

    public Student(String name, String department, Bitmap photo, Date dateOfBirth, int courseId) {
        this.name = name;
        this.department = department;
        this.photo = photo;
        this.dateOfBirth = dateOfBirth;
        this.courseId = courseId;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Ignore
    public Student(int id, String name, String department, Bitmap photo, Date dateOfBirth, int courseId) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.photo = photo;
        this.dateOfBirth = dateOfBirth;
        this.courseId = courseId;
    }
}
