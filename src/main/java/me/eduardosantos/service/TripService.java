package me.eduardosantos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import me.eduardosantos.model.City;
import me.eduardosantos.model.Hotel;
import me.eduardosantos.model.Room;
import me.eduardosantos.model.Trip;
import me.eduardosantos.model.TripRoom;

@Service
public class TripService {
	private static Long lastId = 0l;
	private static final Float commission = 0.7f;

	public Trip getTripFrom(List<Hotel> hotels, City city, long bookingDays, Integer amountOfAdult, Integer amountOfChild) {
		Trip trip = new Trip();
		trip.setId(lastId++);
		trip.setCityName(city.getDescription());
		for (Hotel hotel : hotels) {
			for (Room room : hotel.getRooms()) {
				TripRoom tripRoom = TripRoom.of(room, commission, bookingDays, amountOfAdult, amountOfChild);
				trip.add(tripRoom);
			}
		}
		return trip;
	}
}
