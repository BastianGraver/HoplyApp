package com.example.hoply.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM Users")
    List<Users> getAll();

    @Query("DELETE FROM Users")
    public void nukeTable();

    @Insert
    void insert(Users user);

    @Delete
    void delete(Users user);

}
