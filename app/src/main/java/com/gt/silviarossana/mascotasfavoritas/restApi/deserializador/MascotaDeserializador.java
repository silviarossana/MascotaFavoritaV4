package com.gt.silviarossana.mascotasfavoritas.restApi.deserializador;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.gt.silviarossana.mascotasfavoritas.pojo.Mascota;
import com.gt.silviarossana.mascotasfavoritas.pojo.MascotaRestApi;
import com.gt.silviarossana.mascotasfavoritas.restApi.JsonKeys;
import com.gt.silviarossana.mascotasfavoritas.restApi.model.MascotaResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Silvia Rossana on 18/02/2017.
 */

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse>{

        @Override
        public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            Gson gson = new Gson();
            MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
            JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
            mascotaResponse.setMascotas(deserializarContactoJson(mascotaResponseData));

            return  mascotaResponse;
            //return null;
        }

        private ArrayList<MascotaRestApi> deserializarContactoJson(JsonArray mascotaResponseData){
            ArrayList<MascotaRestApi> mascotaRestApi = new ArrayList<>();

            //Toast.makeText(this, mascotaResponseData.size() + " Deserializador", Toast.LENGTH_LONG).show();



            for (int i = 0; i < mascotaResponseData.size(); i++){
                JsonObject contactoResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();
                JsonObject userJson = contactoResponseDataObject.getAsJsonObject(JsonKeys.USER);

                String id = userJson.get(JsonKeys.USER_ID).getAsString();
                String nombreCompleto = userJson.get(JsonKeys.FULL_NAME).getAsString();

                JsonObject imageJson = contactoResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGE);
                JsonObject standarResolutionJson = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
                String urlFoto = standarResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

                JsonObject likesJson = contactoResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
                int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

                MascotaRestApi mascotaRestApiActual = new MascotaRestApi();
                mascotaRestApiActual.setId(id);
                mascotaRestApiActual.setNombreCompleto(nombreCompleto);
                mascotaRestApiActual.setUrlFoto(urlFoto);
                mascotaRestApiActual.setLikes(likes);

                mascotaRestApi.add(mascotaRestApiActual);
            }

            return mascotaRestApi;
        }


}
