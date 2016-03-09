import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Optional;

public class ReductionExample {

    public static void main(String[] args) {

	List<Integer> list = ImmutableList.of(30,20,10, 50);

	Integer sum =
	list.stream()
//		.reduce(0, (i1, i2) -> i1 + i2);
		.reduce(0, Integer::sum); // 0 ~ identity value or default value

	Optional<Integer> max =
	list.stream()
		.reduce(Integer::max); // ~ default value should not be defined for max

	System.out.println("sum = " + sum);
	System.out.println("max = " + max.get());
    }
}
