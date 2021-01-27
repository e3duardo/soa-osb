package me.eduardosantos.util;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import me.eduardosantos.model.Hotel;
import me.eduardosantos.serializer.HotelDeserializer;

public abstract class GsonUtil {

	public static Type hotelListType = new TypeToken<ArrayList<Hotel>>(){}.getType();

	public static Gson newGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Hotel.class, new HotelDeserializer());
	    return gsonBuilder.create();
	}

	public static Hotel fromHotelJson(InputStreamReader isr) {
		return newGson().fromJson(isr, Hotel.class);
	}
	public static List<Hotel> fromHotelListJson(InputStreamReader isr) {
		return newGson().fromJson(isr, hotelListType);
	}
}
