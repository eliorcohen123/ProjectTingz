package com.eliorcohen.projecttingz.PagesPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.eliorcohen.projecttingz.AdaptersPackage.AdapterMovieList;
import com.eliorcohen.projecttingz.R;
import com.eliorcohen.projecttingz.RoomFavoritesPackage.RoomViewModelFavorites;
import com.eliorcohen.projecttingz.UtilsPackage.ApplicationUtil;
import com.eliorcohen.projecttingz.UtilsPackage.ItemDecoration;

public class MovieListActivity extends AppCompatActivity {

    private RoomViewModelFavorites mRoomViewModelFavorites;
    private AdapterMovieList mAdapterMovieList;
    private RecyclerView recyclerViewMovieList;
    private ItemDecoration mItemDecoration;
    private static final String TAG = "checkTingz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        initUI();
        initRV();
    }

    private void initUI() {
        recyclerViewMovieList = findViewById(R.id.recyclerViewMovieList);

        mRoomViewModelFavorites = new RoomViewModelFavorites(ApplicationUtil.getApplication());

        mAdapterMovieList = new AdapterMovieList(this);
    }

    private void initRV() {
        if (mItemDecoration == null) {
            mItemDecoration = new ItemDecoration(30);
            recyclerViewMovieList.addItemDecoration(mItemDecoration);
        }
        recyclerViewMovieList.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMovieList.setAdapter(mAdapterMovieList);

        putData();
    }

    private void putData() {
        mRoomViewModelFavorites.getAllData().observe(this, roomFavorites -> {
            mAdapterMovieList.setData(roomFavorites);

            Log.i(TAG, roomFavorites.size() + " ");
        });
    }

}
