package me.eduardosantos.model;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.format.annotation.NumberFormat;

import me.eduardosantos.util.BigDecimalUtil;

public class TripRoom {
	private Long roomID;
	private String categoryName;
	@NumberFormat(pattern = "0.##")
	private BigDecimal totalPrice;
	private TripRoomPrice priceDetail;

	public static TripRoom of(Room room, Float commission, long bookingDays, Integer amountOfAdult, Integer amountOfChild) {
		TripRoom tripRoom = new TripRoom();
		tripRoom.setRoomID(room.getRoomID());
		tripRoom.setCategoryName(room.getCategoryName());

		BigDecimal perAdult = room.getPrice().getAdult();
		BigDecimal perChild = room.getPrice().getChild();

		BigDecimal pricePerDayAdult = perAdult.divide(new BigDecimal(commission), 2, RoundingMode.HALF_UP);
		BigDecimal pricePerDayChild = perChild.divide(new BigDecimal(commission), 2, RoundingMode.HALF_UP);

		BigDecimal totalAdult = pricePerDayAdult.multiply(new BigDecimal(amountOfAdult));
		BigDecimal totalChild = pricePerDayChild.multiply(new BigDecimal(amountOfChild));

		BigDecimal totalPrice = totalAdult.add(totalChild);

		totalPrice = BigDecimalUtil.clean(totalPrice.multiply(new BigDecimal(bookingDays)));

		tripRoom.setTotalPrice(totalPrice);

		TripRoomPrice tripRoomPrice = new TripRoomPrice();
		tripRoomPrice.setPricePerDayAdult(pricePerDayAdult);
		tripRoomPrice.setPricePerDayChild(pricePerDayChild);
		tripRoom.setPriceDetail(tripRoomPrice);
		return tripRoom;
	}

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

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public TripRoomPrice getPriceDetail() {
		return priceDetail;
	}

	public void setPriceDetail(TripRoomPrice priceDetail) {
		this.priceDetail = priceDetail;
	}

}
