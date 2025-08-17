package com.dd.tuanpm;

import java.util.*;
import java.util.stream.*;

public class FlatMapEx {
	 public static void main(String[] args) {
		 //Bài 1: Tách câu thành danh sách từ
	        List<String> sentences = Arrays.asList("Java is fun",
	                "I love coding",
	                "Stream API is powerful");
	        List<String> words = sentences.stream()
	                .flatMap(s -> Arrays.stream(s.split(" "))) 
	                .distinct()
	                .collect(Collectors.toList());

	        System.out.println(words);
	        
	        //Bài 2: Gộp danh sách số và tính tổng bình phương
	        List<List<Integer>> numbers = Arrays.asList(
	                Arrays.asList(1, 2, 3),
	                Arrays.asList(4, 5),
	                Arrays.asList(6, 7, 8, 9)
	        );

	        int sum = numbers.stream()
	                .flatMap(list -> list.stream()) 
	                .mapToInt(n -> n * n)          
	                .sum();

	        System.out.println("Tổng bình phương = " + sum);
	        //Bài 3: Cartesian Product (Ghép tên với điểm)
	        List<String> names = Arrays.asList("Nam", "Lan", "Hoa");
	        List<Integer> scores = Arrays.asList(8, 9);

	        List<String> pairs = names.stream()
	                .flatMap(name -> scores.stream()
	                        .map(score -> "(" + name + ", " + score + ")")) 
	                .collect(Collectors.toList());

	        System.out.println(pairs);
	    }
	 
}
