package com.atulj.chatapplication.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.atulj.chatapplication.db.dao.MessageDao;
import com.atulj.chatapplication.db.dao.UserDao;
import com.atulj.chatapplication.db.entity.Message;
import com.atulj.chatapplication.db.entity.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities ={User.class,Message.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();
    public abstract MessageDao getMessageDao();


    private static final int NUMBER_OF_THREADS = 2;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static volatile AppDatabase instance;

    public static AppDatabase getDatabaseInstance(final Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "app_database"
                    ).fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }
}
