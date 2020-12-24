package com.eliorcohen.projecttingz.RoomFavoritesPackage;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RoomViewModelFavorites extends AndroidViewModel {

    private final RoomRepositoryFavorites mRoomRepositoryFavorites;

    public RoomViewModelFavorites(Application application) {
        super(application);

        mRoomRepositoryFavorites = new RoomRepositoryFavorites(application);
    }

    public LiveData<List<RoomFavorites>> getAllData() {
        return mRoomRepositoryFavorites.getAllData();
    }

    public void insertData(List<RoomFavorites> roomFavorites) {
        mRoomRepositoryFavorites.insertData(roomFavorites);
    }

}
