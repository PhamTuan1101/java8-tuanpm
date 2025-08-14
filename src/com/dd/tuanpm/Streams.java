package com.dd.tuanpm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Streams {

	static class Person {
		String name;
		int age;

		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String toString() {
			return name + age;
		}
	}

	public static void main(String[] args) {

		// ex1
		List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 23, 22, 21, 53, 45, 67, 78, 54, 75, 44);
		arr.stream().filter(n -> n % 2 == 0).forEach(x -> System.out.print(x));
		// ex2

		List<String> s = Arrays.asList("hehe", "h", "aaaaa", "uu", "mmm");
		System.out.println("\nEx 2: ");
		s.stream().filter(x -> x.length() > 3).forEach(System.out::println);

		// Ex3
		List<Person> ps = Arrays.asList(new Person("Tuan", 22), new Person("Tri", 6), new Person("Tu", 19));
		System.out.println("\nEx 3: ");
		ps.stream().filter(p -> p.age > 18).sorted(Comparator.comparingInt(p -> p.age)).forEach(System.out::println);
	}
}
