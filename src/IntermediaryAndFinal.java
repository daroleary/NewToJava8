import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinal {

    public static void main(String[] args) {

	Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

	Predicate<String> p1 = Predicate.isEqual("two");
	Predicate<String> p2 = Predicate.isEqual("three");

	List<String> list = new ArrayList<>();

//	stream
//		.peek(System.out::println)
//		.filter(p1.or(p2))
//		.peek(list::add); intermediary step ~ lazy

//	System.out.println("Done!");
//	System.out.println("size = " + list.size()); -- nothing performed until final step i.e. reduce is executed

	stream
		.peek(System.out::println)
		.filter(p1.or(p2))
		.forEach(list::add); // reduce method is called (final operation)

	System.out.println("Done!");
	System.out.println("size = " + list.size()); // therefore we get stream is operated on
    }
}
