package com.dd.tuanpm;

import java.util.Arrays;
import java.util.List;

public class StreamsFilterExamples {
	public static void main(String[] args) {
//		Bài 1 (Cơ bản)
//		Đề bài:
//		Cho danh sách số nguyên List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//		Hãy dùng Stream + filter() để:
//		Lọc ra các số chẵn.
//		In ra màn hình.
//		Mục tiêu: làm quen với filter() cơ bản.
		System.out.println("EX1: ");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		numbers.stream().filter(a -> a % 2 == 0).forEach(System.out::println);

//		Bài 2 (Trung bình)
//		Đề bài:
//		Cho danh sách chuỗi:
//		List<String> names = Arrays.asList("Tuan", "Nam", "An", "Long", "Trang", "Hanh");
//		Hãy dùng Stream + filter() để:
//		Lọc ra các tên có độ dài > 3 ký tự.
//		Lọc tiếp chỉ lấy tên bắt đầu bằng chữ 'T'.
//		In ra màn hình danh sách kết quả.
//		Mục tiêu: kết hợp filter() nhiều điều kiện.
		System.out.println("EX2: ");
		List<String> names = Arrays.asList("Tuan", "Nam", "An", "Long", "Trang", "Hanh");
		names.stream().filter(a -> a.length() > 3).filter(a -> a.startsWith("T")).forEach(System.out::println);

//		Bài 3 (Nâng cao)
//		Đề bài:
//		Cho danh sách List<Employee> với class:
//		class Employee {
//		    String name;
//		    int age;
//		    double salary;
//		}
//		Danh sách:
//		List<Employee> employees = Arrays.asList(
//		    new Employee("Tuan", 22, 600.0),
//		    new Employee("Nam", 30, 1200.0),
//		    new Employee("Hoa", 27, 800.0),
//		    new Employee("Linh", 35, 2000.0)
//		);
//		Hãy dùng Stream + filter() để:
//		Lọc ra các nhân viên có tuổi > 25 và lương > 1000.
//		Sắp xếp danh sách kết quả theo tuổi tăng dần.
//		In ra màn hình tên + tuổi + lương.
//		Mục tiêu: áp dụng filter() + sort() + forEach() trên object.

		class Employee {
			private String name;
			private int age;
			private double salary;

			public Employee(String name, int age, double salary) {
				super();
				this.name = name;
				this.age = age;
				this.salary = salary;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public int getAge() {
				return age;
			}

			public void setAge(int age) {
				this.age = age;
			}

			public double getSalary() {
				return salary;
			}

			public void setSalary(double salary) {
				this.salary = salary;
			}

			public String toString() {
				return "Name: " + name + ", Age: " + age + ", Salary: " + salary;
			}
		}
		System.out.println("EX3: ");
		List<Employee> employees = Arrays.asList(new Employee("Tuan", 22, 600.0), new Employee("Nam", 30, 1200.0),
				new Employee("Hoa", 27, 800.0), new Employee("Linh", 35, 2000.0));
		employees.stream().filter(a -> a.getAge() > 25).filter(a -> a.getSalary() > 1000)
				.sorted((a, b) -> a.getAge() - b.getAge()).forEach(System.out::println);
	}
}
