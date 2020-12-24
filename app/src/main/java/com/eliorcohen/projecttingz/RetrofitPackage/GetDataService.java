package com.eliorcohen.projecttingz.RetrofitPackage;

import com.eliorcohen.projecttingz.ModelsPackage.TotalModel;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;
import rx.Observable;

public interface GetDataService {

    @GET()
    Observable<ArrayList<TotalModel>> getAllData(@Header("Content-Type") String token1, @Url String url);
}
