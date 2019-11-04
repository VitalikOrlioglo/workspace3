package app;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		String[] namenArr = {"Max", "Otto", "Baran", "Koziol", "Koziol"};
		List<String> namenList = Arrays.asList(namenArr);
		
		// konvertieren zu Stream
		Stream<String> streamA = Arrays.stream(namenArr); // Array zu Stream
		Stream<String> streamL = namenList.stream();
		
		// distinct -> eindeutig
		Stream<String> distinctStream = streamL.distinct();
		System.out.println(distinctStream.collect(Collectors.toList()));
		
		// filter
		List<User> users = Arrays.asList(new User("Max", 12), new User("Inge", 23), new User("Anton", 53));
		// Predicate<T> - boolean test(T t);
		List<User> oldUsers = users.stream().
								filter(u -> u.getAlter()>=18).
								collect(Collectors.toList());
		System.out.println(oldUsers);
		
		// map - Zieldatentyp verandern
		// java.util.function.Function - R apply(T t);
		List<String> usernames = users.stream().
								filter(u -> u.getAlter()>=18).
								map(u -> u.getName()). // ab hier String-Stream
								collect(Collectors.toList());
		System.out.println(usernames);
		
		// reduce - reduziert Menge auf ein Element
		User reduceUser = users.stream().
							reduce( (u1, u2) -> u1.getAlter() < u2.getAlter() ?u1:u2 ).
							get();
		System.out.println(reduceUser);
	}

}
