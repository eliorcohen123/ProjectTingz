package com.eliorcohen.projecttingz.AdaptersPackage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eliorcohen.projecttingz.PagesPackage.MovieDetailsActivity;
import com.eliorcohen.projecttingz.R;
import com.eliorcohen.projecttingz.RoomFavoritesPackage.RoomFavorites;

import java.util.List;

public class AdapterMovieList extends RecyclerView.Adapter<ViewHolderMovieList> {

    private final LayoutInflater mInflater;
    private List<RoomFavorites> mRoomFavorites;

    public AdapterMovieList(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolderMovieList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.adapter_movie_list, parent, false);
        return new ViewHolderMovieList(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMovieList holder, final int position) {
        if (mRoomFavorites != null) {
            RoomFavorites current = mRoomFavorites.get(position);
            holder.releaseYearAdapterMovieList.setText(String.valueOf(current.getReleaseYear()));
            holder.linearLayoutAdapterMovieList.setOnClickListener(v -> {
                Intent intentToMovieList = new Intent(mInflater.getContext(), MovieDetailsActivity.class);
                intentToMovieList.putExtra(mInflater.getContext().getString(R.string.movie_list_data), current);
                mInflater.getContext().startActivity(intentToMovieList);
            });
        }

        setFadeAnimation(holder.itemView);
    }

    public void setData(List<RoomFavorites> roomFavorites) {
        this.mRoomFavorites = roomFavorites;
        notifyDataSetChanged();
    }

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1500);
        view.startAnimation(anim);
    }

    @Override
    public int getItemCount() {
        if (mRoomFavorites != null)
            return mRoomFavorites.size();
        else return 0;
    }

}
