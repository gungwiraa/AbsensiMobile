package com.example.ux32vd.absensimobile.api;
import com.example.ux32vd.absensimobile.model.Response;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {

    @FormUrlEncoded
    @POST("login/ortu")
    Call<Response> saveLogin (@Field("username") String username,
                                @Field("password") String password);
    @GET("ortu/riwayat/[id_ortu]")
    Call<Response> showRiwayat (@Path("id_ortu")int id_ortu);

}

