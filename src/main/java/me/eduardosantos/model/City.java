package me.eduardosantos.model;

public enum City {
	PORTO_SEGURO(1032l, "Porto Seguro"), RIO_DE_JANEIRO(7110l, "Rio de Janeiro"), SAO_PAULO(9626l, "São Paulo");

	private Long code;
	private String description;

	City(Long code, String description) {
		this.code = code;
		this.description = description;
	}

	public Long getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static City fromCode(Long code) {
		for(City city:values()) {
			if(city.getCode().equals(code)) {
				return city;
			}
		}
		return null;
	}

}
