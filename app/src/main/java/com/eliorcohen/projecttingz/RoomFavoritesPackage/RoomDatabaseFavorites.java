package com.eliorcohen.projecttingz.RoomFavoritesPackage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {RoomFavorites.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class RoomDatabaseFavorites extends RoomDatabase {

    public abstract RoomDaoFavorites roomDao();

    private static volatile RoomDatabaseFavorites INSTANCE;

    public static RoomDatabaseFavorites getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabaseFavorites.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabaseFavorites.class,
                            "room_database_favorites")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
