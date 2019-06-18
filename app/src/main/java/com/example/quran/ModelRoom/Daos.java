package com.example.quran.ModelRoom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

@Dao
public interface Daos {

    @Insert
    public void InsertFragment(FragmentState fragmentState);
    @Update
    public  void UpdatFragment(FragmentState fragmentState);
}
