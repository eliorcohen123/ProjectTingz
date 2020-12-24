package com.eliorcohen.projecttingz.RoomFavoritesPackage;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RoomRepositoryFavorites {

    private final RoomDaoFavorites mRoomDaoFavorites;
    private final LiveData<List<RoomFavorites>> mAllRoomFavorites;
    private final RoomDatabaseFavorites mRoomDatabaseFavorites;

    public RoomRepositoryFavorites(Application application) {
        mRoomDatabaseFavorites = RoomDatabaseFavorites.getDatabase(application);
        mRoomDaoFavorites = mRoomDatabaseFavorites.roomDao();
        mAllRoomFavorites = mRoomDaoFavorites.getAllData();
    }

    public LiveData<List<RoomFavorites>> getAllData() {
        return mAllRoomFavorites;
    }

    void insertData(List<RoomFavorites> roomFavorites) {
        mRoomDatabaseFavorites.mDatabaseWriteExecutor.execute(() -> mRoomDaoFavorites.insertData(roomFavorites));
    }

}
