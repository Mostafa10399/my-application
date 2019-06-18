package com.example.quran.ModelRoom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {FragmentState.class}, version = 4, exportSchema = false)
public abstract class MyData extends RoomDatabase {
    public abstract Daos toDaos();

    private static MyData instance;

    public static MyData getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MyData.class, "FragmentState-Database").allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build();

        }
        return instance;
    }


}
