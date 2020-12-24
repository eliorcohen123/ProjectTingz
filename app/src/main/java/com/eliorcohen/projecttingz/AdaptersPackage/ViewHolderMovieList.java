package com.eliorcohen.projecttingz.AdaptersPackage;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.eliorcohen.projecttingz.R;

public class ViewHolderMovieList extends RecyclerView.ViewHolder {

    public TextView releaseYearAdapterMovieList;
    public LinearLayout linearLayoutAdapterMovieList;

    public ViewHolderMovieList(View itemView) {
        super(itemView);

        releaseYearAdapterMovieList = itemView.findViewById(R.id.releaseYearAdapterMovieList);
        linearLayoutAdapterMovieList = itemView.findViewById(R.id.linearLayoutAdapterMovieList);
    }

}
