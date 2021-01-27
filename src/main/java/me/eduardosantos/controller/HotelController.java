package me.eduardosantos.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.eduardosantos.model.City;
import me.eduardosantos.model.Hotel;
import me.eduardosantos.model.Trip;
import me.eduardosantos.partner.HotelApi;
import me.eduardosantos.service.TripService;

@RestController
public class HotelController {

	@Resource
    private TripService tripService;

	@GetMapping("/trip")
	public Trip trip(
			@RequestParam(value = "cityCode") Long cityCode,
			@RequestParam(value = "checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate checkin,
			@RequestParam(value = "checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout,
			@RequestParam(value = "amountOfAdult") Integer amountOfAdult,
			@RequestParam(value = "amountOfChild") Integer amountOfChild
			) {

		City city = City.fromCode(cityCode);
		List<Hotel> hotels = HotelApi.retornarHoteisPorCidade(city);

		long bookingDays = ChronoUnit.DAYS.between(checkin, checkout);

		return tripService.getTripFrom(hotels, city, bookingDays, amountOfAdult, amountOfChild);
	}

	@GetMapping("/hotels/{hotelID}/trip")
	public Trip tripByHotel(
			@PathVariable Long hotelID,
			@RequestParam(value = "checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate checkin,
			@RequestParam(value = "checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout,
			@RequestParam(value = "amountOfAdult") Integer amountOfAdult,
			@RequestParam(value = "amountOfChild") Integer amountOfChild
			) {

		List<Hotel> hotels = HotelApi.retornarHotelPorId(hotelID);
		City city = hotels.get(0).getCity();

		long bookingDays = ChronoUnit.DAYS.between(checkin, checkout);

		return tripService.getTripFrom(hotels, city, bookingDays, amountOfAdult, amountOfChild);
	}
}