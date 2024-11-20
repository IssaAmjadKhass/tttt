package com.example.roomdatabasissa;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Student.class, Course.class}, version = 1, exportSchema = false)
@TypeConverters(Converter.class)  // Register the Converter class globally
public abstract class DataBas extends RoomDatabase {

    public abstract StudentDao studentDao();

    public abstract CourseDao courseDao();

    private static volatile DataBas INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static DataBas getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DataBas.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DataBas.class, "my_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
