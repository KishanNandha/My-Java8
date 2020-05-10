package programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02StreamOperations {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		//Operations which returns stream are called intermediate operation
		//Terminal operation: operations which converts stream to other type are called terminal operation.
		
		
		List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		numbers.stream()
			.distinct() //Stream<T> Intermediate
			.sorted() //Stream<T>
			.forEach(System.out::println); //void

		List<Integer> squaredNumbers = numbers.stream()
				.map(number -> number * number) //Stream<R>
				.collect(Collectors.toList()); //R

		List<Integer> evenNumbersOnly = numbers.stream()
				.filter(x -> x % 2 == 0) //Stream<T>
				.collect(Collectors.toList());
		
		int sum = numbers.stream()
				.reduce(0, (x,y) -> x*x + y*y); //T
		
		int greatest = numbers.stream()
				.reduce(Integer.MIN_VALUE, (x,y)-> x>y ? x:y);
		
		List<String> courses = Arrays.asList("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

		List<String> coursesSortedByLengthOfCourseTitle = courses.stream()
				.sorted(Comparator.comparing(str -> str.length()))
				.collect(Collectors.toList());
		
	}
}
