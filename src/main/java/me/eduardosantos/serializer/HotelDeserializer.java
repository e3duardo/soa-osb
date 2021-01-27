package me.eduardosantos.serializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import me.eduardosantos.model.City;
import me.eduardosantos.model.Hotel;
import me.eduardosantos.model.Room;

public class HotelDeserializer implements JsonDeserializer<Hotel> {

	@Override
	public Hotel deserialize(JsonElement jElement, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject jObject = jElement.getAsJsonObject();

		Long id = jObject.get("id").getAsLong();
		String name = jObject.get("name").getAsString();

		Long cityCode = jObject.get("cityCode").getAsLong();
//        String cityName = jObject.get("cityName").getAsString();
		City city = City.fromCode(cityCode);

		Type type = new TypeToken<ArrayList<Room>>() {
		}.getType();
		List<Room> rooms = context.deserialize(jObject.get("rooms"), type);

		Hotel hotel = new Hotel();
		hotel.setId(id);
		hotel.setName(name);
		hotel.setCity(city);
		hotel.setRooms(rooms);
		return hotel;
	}

}
