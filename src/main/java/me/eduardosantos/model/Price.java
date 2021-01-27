package me.eduardosantos.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Price implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal adult;
	private BigDecimal child;

	public BigDecimal getAdult() {
		return adult;
	}

	public void setAdult(BigDecimal adult) {
		this.adult = adult;
	}

	public BigDecimal getChild() {
		return child;
	}

	public void setChild(BigDecimal child) {
		this.child = child;
	}

}
