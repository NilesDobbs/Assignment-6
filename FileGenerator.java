package assignmentSix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileGenerator {
	//Testing Format
	private static TeslaImport carGenerator(String[] attributes) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");
		YearMonth date = YearMonth.parse(attributes[0], formatter);
		Integer sales = Integer.parseInt(attributes[1]);
		return new TeslaImport(date, sales);
	}
	
	public static List<TeslaImport> teslaFileRead(String filename) throws IOException  {
//		TestingFormat formatImport = new TestingFormat();
		
		//Instantiate a new ArrayList for our file's to read from TeslaImport. 
		List<TeslaImport> teslas = new ArrayList<>();
		BufferedReader fileReader = null; 
		
		/* We'll create a try... catch to read though every line in the database until it stops, while also 
		splitting the string with a space. */
		try {
			fileReader = new BufferedReader(new FileReader(filename));
			String line = fileReader.readLine();
			
			//While reading through each line, split the string and add the change to TeslaInfo
			while ((line = fileReader.readLine()) != null) {
				String[] info = line.split(" , ");
				TeslaImport addSplit = carGenerator(info);
				teslas.add(addSplit);
			}
			
		//Close the fileReader after it's read through each line in the database.
		} finally {
			if (fileReader != null)
				fileReader.close();
		}
		return teslas;
	}
}