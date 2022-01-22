package assignmentSix;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public class SalesGenerator {
	
	//This class will print out the Maximum and minimum Sales data from the .getSales() in TeslaImport.
	public static void teslaReport(Set<Entry<String, List<TeslaImport>>> entrySet, List<TeslaImport> teslaModel, String modelName) throws IOException {
		
		//This comparator will sort the sales array values.
		Comparator<TeslaImport> comparativeOperator = Comparator.comparing(tesla -> tesla.getSales());
		
		//This will layout the year in ascdending order and sum of the sales data for each year.
		entrySet.stream().sorted(Entry.comparingByKey()).forEach(entry -> System.out.println("Month: " + entry.getKey() + " -> " + entry
	    .getValue().stream().mapToInt(tesla -> tesla.getSales().intValue()).sum()));
		
		TeslaImport maximumSales = teslaModel.stream().max(comparativeOperator).orElseThrow(NoSuchElementException::new);
		TeslaImport minimumSales = teslaModel.stream().min(comparativeOperator).orElseThrow(NoSuchElementException::new);
			
		//Print out the maximum and minimum results from TeslaReport.
		System.out.println(modelName + " Yearly Sales Report");
		System.out.println("The BEST month for " + modelName + " was: " + maximumSales.getDate());
		System.out.println("The WORST month for " + modelName + " was: " + minimumSales.getDate());			                                                                		
	} 
	
	public static void main(String[] args) throws IOException {
		
		/* To produce the sales values from TeslaData, we need to instantiate the TeslaData variable to import
		all the EntrySet models */
		TeslaData analysedData = new TeslaData();
		
		/*The FileReader from our FileGenerator class needs to be instantiated to model3. We can use to when
		when reporting our data in TeslaReport */
		List<TeslaImport> model3 = FileGenerator.teslaFileRead("model3.csv");
		Set<Entry<String, List<TeslaImport>>> entrySetModel3 = analysedData.entryByYear(model3);
		teslaReport(entrySetModel3, model3, "Model 3");
		
		/*The FileReader from our FileGenerator class needs to be instantiated to modelS. We can use to when
		when reporting our data in TeslaReport */
		List<TeslaImport> modelS = FileGenerator.teslaFileRead("modelS.csv");
		Set<Entry<String, List<TeslaImport>>> entrySetModelS = analysedData.entryByYear(modelS);
		teslaReport(entrySetModelS, modelS, "Model S");
		
		/*The FileReader from our FileGenerator class needs to be instantiated to modelX. We can use to when
		when reporting our data in TeslaReport */
		List<TeslaImport> modelX = FileGenerator.teslaFileRead("modelX.csv");	
		Set<Entry<String, List<TeslaImport>>> entrySetModelX = analysedData.entryByYear(modelX);		
		teslaReport(entrySetModelX, modelX, "Model X");
	}
}
