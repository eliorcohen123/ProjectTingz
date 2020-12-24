package com.eliorcohen.projecttingz.PagesPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.eliorcohen.projecttingz.ModelsPackage.TotalModel;
import com.eliorcohen.projecttingz.R;
import com.eliorcohen.projecttingz.RetrofitPackage.GetDataService;
import com.eliorcohen.projecttingz.RetrofitPackage.RetrofitClientInstance;
import com.eliorcohen.projecttingz.RoomFavoritesPackage.RoomFavorites;
import com.eliorcohen.projecttingz.RoomFavoritesPackage.RoomViewModelFavorites;
import com.eliorcohen.projecttingz.UtilsPackage.ApplicationUtil;

import java.util.ArrayList;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SplashScreenActivity extends AppCompatActivity {

    private RoomViewModelFavorites mRoomViewModelFavorites;
    private final ArrayList<RoomFavorites> mArrayListRoomData = new ArrayList<>();
    private static final String TAG = "checkTingz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        init();
        getData();
    }

    private void init() {
        mRoomViewModelFavorites = new RoomViewModelFavorites(ApplicationUtil.getApplication());
    }

    private void getData() {
        GetDataService apiService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Observable<ArrayList<TotalModel>> observable = apiService.getAllData("application/json", "/json/movies.json")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<ArrayList<TotalModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ArrayList<TotalModel> totalModelArrayList) {
                addDataToRoom(totalModelArrayList);
            }
        });
    }

    private void addDataToRoom(ArrayList<TotalModel> totalModelArrayList) {
        try {
            for (int i = 0; i < totalModelArrayList.size(); i++) {
                RoomFavorites roomFavorites = new RoomFavorites(
                        totalModelArrayList.get(i).getTitle(), totalModelArrayList.get(i).getImage(), totalModelArrayList.get(i).getRating(),
                        totalModelArrayList.get(i).getReleaseYear(), totalModelArrayList.get(i).getGenre());
                mArrayListRoomData.add(roomFavorites);
            }

            mRoomViewModelFavorites.insertData(mArrayListRoomData);

            Log.i(TAG, mArrayListRoomData.size() + " ");

            startActivity(new Intent(this, MovieListActivity.class));
        } catch (Exception e) {
            Log.i(TAG, e.getMessage() + " ");
        }
    }

}
