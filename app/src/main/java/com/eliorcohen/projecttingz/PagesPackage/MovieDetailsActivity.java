package com.eliorcohen.projecttingz.PagesPackage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.eliorcohen.projecttingz.R;
import com.eliorcohen.projecttingz.RoomFavoritesPackage.RoomFavorites;

public class MovieDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageMovieDetails;
    private TextView titleMovieDetails, ratingMovieDetails, releaseYearMovieDetails, genreMovieDetails;
    private Button btnBackMovieList;
    private RoomFavorites mRoomFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        initUI();
        initListeners();
    }

    private void initUI() {
        imageMovieDetails = findViewById(R.id.imageMovieDetails);
        titleMovieDetails = findViewById(R.id.titleMovieDetails);
        ratingMovieDetails = findViewById(R.id.ratingMovieDetails);
        releaseYearMovieDetails = findViewById(R.id.releaseYearMovieDetails);
        genreMovieDetails = findViewById(R.id.genreMovieDetails);
        btnBackMovieList = findViewById(R.id.btnBackMovieList);

        mRoomFavorites = (RoomFavorites) getIntent().getExtras().getSerializable(getString(R.string.movie_list_data));

        setData();
    }

    private void initListeners() {
        btnBackMovieList.setOnClickListener(this);
    }

    private void setData() {
        Glide.with(this).load(mRoomFavorites.getImage()).into(imageMovieDetails);
        titleMovieDetails.setText(mRoomFavorites.getTitle());
        ratingMovieDetails.setText(String.valueOf(mRoomFavorites.getRating()));
        releaseYearMovieDetails.setText(String.valueOf(mRoomFavorites.getReleaseYear()));

        StringBuilder sb = new StringBuilder();
        for (String str : mRoomFavorites.getGenre()) {
            sb.append(str).append(",");
        }
        genreMovieDetails.setText(sb.delete(sb.length() - 1, sb.length()));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnBackMovieList) {
            onBackPressed();
        }
    }

}
