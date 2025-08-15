package com.dd.tuanpm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressionEx {
	static class Product {
		private String name;
		private double price;

		public Product(String name, double price) {
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "name: " + name + ", price: " + price;
		}

	}

	static class Student {
		private String name;
		private int age;
		private double score;

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public double getScore() {
			return score;
		}

		public void setScore(double score) {
			this.score = score;
		}

		public Student(String name, int age, double score) {
			this.name = name;
			this.age = age;
			this.score = score;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String toString() {
			return "Name: " + name + ", age: " + age + ", score: " + score;
		}
	}

	public static void main(String[] args) {
//		Bài 1 – Cơ bản: Sắp xếp danh sách số nguyên
//		Cho List<Integer> gồm: 5, 1, 8, 3, 2, 9.
//		Dùng lambda với Collections.sort() để:
//		Sắp xếp tăng dần.
//		Sắp xếp giảm dần.
//		In kết quả sau mỗi lần sắp xếp.
//		Mục tiêu: Làm quen với cú pháp Comparator Lambda trên kiểu dữ liệu đơn giản.
		System.out.println("Ex1: ");
		List<Integer> listInt = Arrays.asList(5, 1, 8, 3, 2, 9, 7);
		Collections.sort(listInt);
		System.out.println(listInt);
		Collections.sort(listInt, (a, b) -> b - a);
		System.out.println(listInt);

//		Bài 2 – Trung bình: Sắp xếp danh sách đối tượng theo 1 tiêu chí
//		Tạo class Product gồm: String name, double price.
//		Tạo List<Product> gồm ít nhất 5 sản phẩm.
//		Sử dụng Comparator lambda để sắp xếp danh sách theo giá từ thấp đến cao.
//		In ra danh sách đã sắp xếp.
//		Mục tiêu: Áp dụng Comparator Lambda vào sắp xếp đối tượng.
		System.out.println("\nEx2: ");
		List<Product> products = new ArrayList<>();
		products.add(new Product("SP1", 100));
		products.add(new Product("SP2", 10));
		products.add(new Product("SP3", 500));
		products.add(new Product("SP4", 120));
		products.add(new Product("SP5", 50));

		Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
		System.out.println(products);

		products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
		System.out.println(products);
//		Bài 3 – Nâng cao: Sắp xếp đa tiêu chí
//		Tạo class Student gồm: String name, int age, double score.
//		Tạo List<Student> gồm ít nhất 5 sinh viên.
//		Sử dụng Comparator lambda để:
//		Sắp xếp theo score giảm dần.
//		Nếu score bằng nhau, sắp xếp theo tên tăng dần.
//		In ra danh sách sau khi sắp xếp.
//		Mục tiêu: Sử dụng Comparator.thenComparing() để xử lý nhiều tiêu chí sắp xếp.
		System.out.println("\nEx3: ");
		List<Student> students = new ArrayList<>();
		students.add(new Student("Tuan", 22, 10));
		students.add(new Student("Tri", 12, 6));
		students.add(new Student("Long", 25, 5));
		students.add(new Student("Ly", 22, 10));
		students.add(new Student("Quang", 21, 1));

		students.sort((a, b) -> {
			int result = Double.compare(a.getScore(), b.getScore());
			return (result != 0) ? result
					: (a.getName().compareTo(b.getName()) != 0) ? (a.getName().compareTo(b.getName()))
							: (Integer.compare(a.getAge(), b.getAge()));
		});
		System.out.println(students);
		students.sort(Comparator.comparingDouble(Student::getScore).reversed().thenComparing(Student::getName)
				.thenComparing(Student::getAge));
		System.out.println(students);
	}
}
