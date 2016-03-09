import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {

    public static void main(String[] args) {

//	Comparator<String> comparator = new Comparator<String>() {
//
//	    @Override
//	    public int compare(String s1, String s2) {
//		return Integer.compare(s1.length(), s2.length());
//	    }
//	};

	Comparator<String> comparatorLambda = (String s1, String s2) ->
		Integer.compare(s1.length(), s2.length());

	List<String> strings = Arrays.asList("***", "**", "****", "*");
	Collections.sort(strings, comparatorLambda);

	for (String string : strings) {
	    System.out.println(string);
	}
    }
}
