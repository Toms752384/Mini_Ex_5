package com.example.mini_ex_5;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import java.util.List;

@Dao
 public interface PostDao {
 @Query("SELECT * FROM post")
 List<Post> index();

 @Query("SELECT * FROM post WHERE id = :id")
 Post get(int id);

 @Insert
 void insert(Post... posts);

 @Update
 void update(Post... posts);

 @Delete
 void delete(Post... posts);
 }
