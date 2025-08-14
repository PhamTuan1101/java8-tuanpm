package com.dd.tuanpm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LambdaExpression {
	public static void main(String[] args) {
// 		Tạo một danh sách List<String> chứa tên 5 người.
//		In ra tất cả tên bằng forEach + lambda.
//		Chuyển tất cả tên sang chữ in hoa và in ra lại.

		// Test
		List<String> p = new ArrayList<String>();
		p.add("1");
		p.add("2");
		p.forEach(point -> System.out.println(point));

		// Ex1
		List<String> list = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 5 people:");
		while (list.size() < 5) {
			list.add(sc.nextLine());
		}
		System.out.print("List: ");
		list.forEach(p2 -> System.out.print(p2 + "\t"));
		System.out.println("\nList uppercase: ");
		list.forEach(p2 -> System.out.print(p2.toUpperCase() + "\t"));
	}
}
