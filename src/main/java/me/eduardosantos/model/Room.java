package me.eduardosantos.model;

import java.io.Serializable;

public class Room implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long roomID;
	private String categoryName;
	private Price price;

	public Long getRoomID() {
		return roomID;
	}

	public void setRoomID(Long roomID) {
		this.roomID = roomID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

}
