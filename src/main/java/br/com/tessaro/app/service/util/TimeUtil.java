package br.com.tessaro.app.service.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

	TimeUtil(){
		throw new IllegalStateException("Classe utilitária.");
	}

	private static DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static LocalDate toLocalDate(String time) {
		return LocalDate.parse(time, formatterDate);
	}
	
	public static String formatarData(LocalDate data) {
		return data.format(formatterDate);
	}
	
}
