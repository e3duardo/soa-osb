package me.eduardosantos.model;

import java.io.Serializable;
import java.util.List;

public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private City city;
	private List<Room> rooms;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}
