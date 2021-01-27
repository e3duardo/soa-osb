import java.math.BigDecimal;

public class TripRoom {
	private Long roomID;
	private String categoryName;
	private BigDecimal totalPrice;
	private TripRoomPrice priceDetail;

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
