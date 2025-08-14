package com.dd.tuanpm;

@FunctionalInterface
interface calculator {
	int operate(int a, int b);
}

@FunctionalInterface
interface numberCheck {
	boolean check(int n);
}

@FunctionalInterface
interface stringProcessor {
	String process(String s);
}

public class FunctionalInterfacee {
	public static void main(String[] args) {
//		Bài 1 — Máy tính đơn giản
//		Viết chương trình sử dụng Lambda để thực hiện phép cộng, trừ, nhân.
//
//		Bài 2 — Kiểm tra số chẵn
//		Viết Lambda để kiểm tra xem một số có phải là số chẵn hay không.
//
//		Bài 3 — Xử lý chuỗi
//		Viết Lambda để chuyển chuỗi sang chữ in hoa và in ra kết quả.

		// Ex1
		calculator add = (a, b) -> a + b;
		calculator minus = (a, b) -> a - b;
		calculator multiply = (a, b) -> a * b;
		System.out.println("Ex 1: ");
		System.out.println("Add: " + add.operate(1, 5) + " Minus: " + minus.operate(4, 2) + " Multiply: "
				+ multiply.operate(2, 4));

		// Ex2
		numberCheck even = n -> n % 2 == 0;
		System.out.println("Ex 2: " + even.check(10));

		stringProcessor upperCase = s -> s.toUpperCase();
		System.out.println("Ex 3:" + upperCase.process("hehe"));

	}
}
