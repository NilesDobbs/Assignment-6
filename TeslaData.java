package assignmentSix;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TeslaData {
	
	//ArrayList<> tesla = new FileGenerator()<>;

	/* This public method will get the sum of all the values in Column B. The three methods will call entrySet and follow a similar stream 
	pattern from the rest: First, we filter the index in entrySet and get the corresponding Key for each year. Next, we flatMap our
	Values in the year and put them all to a single non-duplicate array list. Afterwards, we maptoInt our Values and use our list to receive 
	the Sales from the year and produce the sum of the values. */
	public long saleSumByYear(Set<Entry<String, List<TeslaImport>>> sortedArray, String year) {	
        return sortedArray.stream()
        		       .filter(input -> input.getKey().equals(year)) 	               
		               .flatMap(input -> input.getValue().stream())
		               .mapToInt(tesla -> tesla.getSales().intValue())		              
		               .sum();	               
	}
	
	/* This public method will get the Maximum value of all the values in Column B. The three methods will call entrySet and follow a similar stream 
	pattern from the rest: First, we filter the index in entrySet and get the corresponding Key for each year. Next, we flatMap our
	Values in the year and put them all to a single non-duplicate array list. Afterwards, we maptoInt our Values and use our list to receive 
	the Sales from the year. We use summaryStatistics to return the summary of elements in this stream. In this case, we need the maximum */
	public int maxSaleByYear(Set<Entry<String, List<TeslaImport>>> sortedArray, String year) {
		return sortedArray.stream()
	                   .filter(input -> input.getKey().equals(year))
	                   .flatMap(input -> input.getValue().stream())
	                   .mapToInt(tesla -> tesla.getSales().intValue())
	                   .summaryStatistics().getMax();
	}
	/* This public method will get the Minimum value of all the values in Column B. The three methods will call entrySet and follow a similar stream 
	pattern from the rest: First, we filter the index in entrySet and get the corresponding Key for each year. Next, we flatMap our
	Values in the year and put them all to a single non-duplicate array list. Afterwards, we maptoInt our Values and use our list to receive 
	the Sales from the year. We use summaryStatistics to return the summary of elements in this stream. In this case, we need the minimum value */
	public int minSaleByYear(Set<Entry<String, List<TeslaImport>>> sortedArray, String year) {
		return sortedArray.stream()
	                   .filter(input -> input.getKey().equals(year))
	                   .flatMap(input -> input.getValue().stream())
	                   .mapToInt(tesla -> tesla.getSales().intValue())
	                   .summaryStatistics().getMin();
	}
	
	/* This public method will group our methods by non-duplicate years. We'll need a stream that will get the Date of each year and implement
	a DateTimeFormatter in 'yyyy' format. Finally, we instantiate it via an entrySet.
	*/
	public Set<Entry<String, List<TeslaImport>>> entryByYear(List<TeslaImport> model) {
		Map<String, List<TeslaImport>> groupedByYear = model.stream()
		.collect(Collectors.groupingBy((tesla) -> tesla.getDate().format(DateTimeFormatter.ofPattern("yyyy"))));
		Set<Entry<String, List<TeslaImport>>> sortedArray = groupedByYear.entrySet();
		return sortedArray;
	}
}