package assignmentSix;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class TestingFormat {
	@SuppressWarnings("unused")
	private static TeslaImport teslaCarGenerator(String[] attributes) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");
		YearMonth date = YearMonth.parse(attributes[0], formatter);
		Integer sales = Integer.parseInt(attributes[1]);
		return new TeslaImport(date, sales);
	}
}