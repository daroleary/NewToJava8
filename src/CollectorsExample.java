import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

    public static void main(String[] args) {
	List<PersonAge> persons = new ArrayList<>();

	try (
	    BufferedReader reader =
		    new BufferedReader(
			    new InputStreamReader(
				    CollectorsExample.class.getResourceAsStream("people_age.txt")));

	    Stream<String> stream = reader.lines();
	) {

	    stream.map(line -> {
		String[] s = line.split(" ");
		PersonAge p = new PersonAge(s[0].trim(), Integer.parseInt(s[1]));
		persons.add(p);
		return p;
	    }).forEach(System.out::println);
	} catch (Exception e) {
	    System.out.println(e);
	}

//	Person [Sarah, 17]
//	Person [Philip, 24]
//	Person [Beth, 26]
//	Person [Simon, 27]
//	Person [Nina, 26]
//	Person [Allan, 31]
//	Person [Leonard, 25]
//	Person [Barbara, 28]

	Optional<PersonAge> youngestOver20 =
	persons.stream().filter(p -> p.getAge() >= 20)
		.min(Comparator.comparing(PersonAge::getAge));

//	Youngest over 20: Person [Philip, 24]
	System.out.println(MessageFormat.format("\nYoungest over 20: {0}", youngestOver20.get()));

	Optional<PersonAge> oldest =
		persons.stream().max(Comparator.comparing(PersonAge::getAge));

//	Oldest: Person [Allan, 31]
	System.out.println(MessageFormat.format("\nOldest: {0}\n", oldest.get()));

	// create a map of what we're grouping by & a list of objects via groupingBy
	Map<Integer, List<PersonAge>> personsByAge = persons.stream()
		.collect(
			Collectors.groupingBy(
				PersonAge::getAge
			)
		);

//	Map by age:
//	{17=[Person [Sarah, 17]], 24=[Person [Philip, 24]], 25=[Person [Leonard, 25]], 26=[Person [Beth, 26], Person [Nina, 26]], 27=[Person [Simon, 27]], 28=[Person [Barbara, 28]], 31=[Person [Allan, 31]]}
	System.out.println("Map by age:\n\t" + personsByAge + "\n");

	// create a map of what we're grouping by & count entries with the same age
	Map<Integer, Long> personsAgeByNumberOfOccurrences = persons.stream()
		.collect(
			Collectors.groupingBy(
				PersonAge::getAge,
				Collectors.counting()
			)
		);

//	Map by age, reducing list of persons to count:
//	{17=1, 24=1, 25=1, 26=2, 27=1, 28=1, 31=1}
	System.out.println("Map by age, reducing list of persons to count:\n\t" + personsAgeByNumberOfOccurrences + "\n");

	// create a map of what we're grouping by & count entries with the same age
	Map<Integer, List<String>> personsAgeByNames = persons.stream()
		.collect(
			Collectors.groupingBy(
				PersonAge::getAge,
				Collectors.mapping(
					PersonAge::getName,
					Collectors.toList()
				)
			)
		);

//	Map by age, mapping to persons names:
//	{17=[Sarah], 24=[Philip], 25=[Leonard], 26=[Beth, Nina], 27=[Simon], 28=[Barbara], 31=[Allan]}
	System.out.println("Map by age, mapping to persons names:\n\t" + personsAgeByNames + "\n");

	// create a map of what we're grouping by & count entries with the same age
	Map<Integer, Set<String>> personsAgeByNamesAsTreeMap = persons.stream()
		.collect(
			Collectors.groupingBy(
				PersonAge::getAge,
				Collectors.mapping(
					PersonAge::getName,
					Collectors.toCollection(TreeSet::new)
				)
			)
		);

//	Map by age, mapping to persons names:
//	{17=[Sarah], 24=[Philip], 25=[Leonard], 26=[Beth, Nina], 27=[Simon], 28=[Barbara], 31=[Allan]}
	System.out.println("Map by age, mapping to persons names:\n\t" + personsAgeByNamesAsTreeMap + "\n");

	// create a map of what we're grouping by & count entries with the same age
	Map<Integer, String> personsAgeByNamesAsString = persons.stream()
		.collect(
			Collectors.groupingBy(
				PersonAge::getAge,
				Collectors.mapping(
					PersonAge::getName,
					Collectors.joining(", ")
				)
			)
		);

//	Map by age, mapping to persons names:
//	{17=Sarah, 24=Philip, 25=Leonard, 26=Beth, Nina, 27=Simon, 28=Barbara, 31=Allan}
	System.out.println("Map by age, mapping to persons names:\n\t" + personsAgeByNamesAsString + "\n");
    }
}
