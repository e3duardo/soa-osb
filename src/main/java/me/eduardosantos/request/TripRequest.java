package me.eduardosantos.request;

import java.time.LocalDate;

public class TripRequest {
	private String cityCode;
	private LocalDate checkin;
	private LocalDate checkout;
	private Integer amountOfAdult;
	private Integer numberOfChild;

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}

	public Integer getAmountOfAdult() {
		return amountOfAdult;
	}

	public void setAmountOfAdult(Integer amountOfAdult) {
		this.amountOfAdult = amountOfAdult;
	}

	public Integer getNumberOfChild() {
		return numberOfChild;
	}

	public void setNumberOfChild(Integer numberOfChild) {
		this.numberOfChild = numberOfChild;
	}

}
