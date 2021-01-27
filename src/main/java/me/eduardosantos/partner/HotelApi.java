package me.eduardosantos.partner;

import java.util.ArrayList;
import java.util.List;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import me.eduardosantos.model.City;
import me.eduardosantos.model.Hotel;
import me.eduardosantos.util.GsonUtil;

public class HotelApi {

	public static List<Hotel> retornarHoteisPorCidade(City city) {
		String url = "https://cvcbackendhotel.herokuapp.com/hotels/avail/" + city.getCode();

		HttpResponse<List<Hotel>> response = Unirest.get(url)
				.asObject(i -> GsonUtil.fromHotelListJson(i.getContentReader()));

		if (response.getStatus() == 200) {
			List<Hotel> hoteis = response.getBody();
			return hoteis;
		}

		return new ArrayList<>();
	}

	public static List<Hotel> retornarHotelPorId(long hotelID) {
		String url = "https://cvcbackendhotel.herokuapp.com/hotels/" + hotelID;

		HttpResponse<List<Hotel>> response = Unirest.get(url)
				.asObject(i -> GsonUtil.fromHotelListJson(i.getContentReader()));

		if (response.getStatus() == 200) {
			List<Hotel> hoteis = response.getBody();
			return hoteis;
		}

		return new ArrayList<>();
	}

}
