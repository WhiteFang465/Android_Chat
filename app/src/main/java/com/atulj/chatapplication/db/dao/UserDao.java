package com.atulj.chatapplication.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.atulj.chatapplication.db.entity.User;

import java.nio.channels.SelectableChannel;
import java.util.List;


@Dao
public interface UserDao {

    @Query("select * from User")
    List<User> getAllUser();

    @Query("select * from User where id = :id")
    User getUser(int id);

    @Query("select exists(select * from User where username = :username)")
    boolean exist(String username);

    @Query("select * from User where username = :username and password = :password")
    User validate(String username, String password);

    @Insert
    void insert(User... users);
    @Update
    void update(User... users);
    @Delete
    void delete(User... users);


}
