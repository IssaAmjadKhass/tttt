package com.example.roomdatabasissa;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Database(entities = {Course.class, Student.class}, version = 1)
public abstract class DataBas extends RoomDatabase {
    private static DataBas INSTANCE;

    public abstract CourseDao courseDao();
    public abstract StudentDao studentDao();

    // إضافة متغير Static للـ Executor
    static final Executor databaseWriteExecutor = Executors.newFixedThreadPool(4);

    public static synchronized DataBas getDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DataBas.class, "room_database")
                    .build();
        }
        return INSTANCE;
    }
}
