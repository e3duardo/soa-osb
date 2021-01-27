package me.eduardosantos.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class BigDecimalUtil {

	public static BigDecimal clean(BigDecimal value) {
		DecimalFormat f = new DecimalFormat("##.00");
		return new BigDecimal(f.format(value));
	}
}
