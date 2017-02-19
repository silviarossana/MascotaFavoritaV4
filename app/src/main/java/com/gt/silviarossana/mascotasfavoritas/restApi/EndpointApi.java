package com.gt.silviarossana.mascotasfavoritas.restApi;

import com.gt.silviarossana.mascotasfavoritas.restApi.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Silvia Rossana on 18/02/2017.
 */

public interface EndpointApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();


    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER_WAFLE)
    Call<MascotaResponse> getRecentMediaWafleSandbox();
}
