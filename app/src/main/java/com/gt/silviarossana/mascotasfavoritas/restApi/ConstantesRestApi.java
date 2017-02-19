package com.gt.silviarossana.mascotasfavoritas.restApi;

/**
 * Created by Silvia Rossana on 18/02/2017.
 */

public class ConstantesRestApi {

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "4666694013.ddd33b0.0002d87b46394597b14962016f7c9165";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/4666694013/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //https://api.instagram.com/v1/users/4617203403/media/recent/?access_token=4617203403.270e1a4.c800eb34430948d5becb09e4f8e46d42
    //INVITADO EN SANDBOX
    public static final String KEY_GET_RECENT_MEDIA_USER_WAFLE = "users/4673917086/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER_WAFLE = KEY_GET_RECENT_MEDIA_USER_WAFLE + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

}
