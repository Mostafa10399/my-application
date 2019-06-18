package com.example.quran.ModelRoom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.v4.app.Fragment;

@Entity
public class FragmentState {

    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo
int position;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public FragmentState() {
    }
    @Ignore
    public FragmentState(int position,String name) {
        this.position = position;
        this.name=name;
    }

}
