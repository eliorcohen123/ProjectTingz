package com.eliorcohen.projecttingz.RoomFavoritesPackage;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RoomDaoFavorites {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertData(List<RoomFavorites> roomFavorites);

    @Query("SELECT * from room_database_favorites ORDER BY releaseYear DESC")
    LiveData<List<RoomFavorites>> getAllData();
}