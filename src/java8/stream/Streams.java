package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
A non-terminal stream operation is an operation that adds a listener to the stream without doing anything else
	filter()
	map()
	flatMap()
	distinct()
	limit()
	peek()

	anyMatch()
	allMatch()
	noneMatch()
	collect()
	count()
	findAny()
	findFirst()
	forEach()
	min()
	max()
	reduce()
	toArray()
 */
public class Streams {
	public void test0() {
		List<String> stringList = new ArrayList<String>();

		stringList.add("one");
		stringList.add("two");
		stringList.add("three");
		stringList.add("one");

		Stream<String> stream = stringList.stream();
		List<String> cnt = stream.limit(2).collect(Collectors.toList());
		System.out.println(cnt.get(0));
	}
	
	public static void main(String[] args) {
		new Streams().test0();
	}

}
