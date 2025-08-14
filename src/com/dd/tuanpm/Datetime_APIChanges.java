package com.dd.tuanpm;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Datetime_APIChanges {
	public static void main(String[] args) {
		/*
		 * Bài tập 1: LocalDate
		 * 
		 * Đề bài:
		 * 
		 * Viết chương trình in ra ngày hôm nay, ngày mai và ngày 7 ngày trước hôm nay.
		 * 
		 * In kết quả theo định dạng yyyy-MM-dd.
		 * 
		 * Gợi ý sử dụng: LocalDate.now(), plusDays(), minusDays(), DateTimeFormatter.
		 * 
		 * Bài tập 2: LocalDateTime + ZonedDateTime
		 * 
		 * Đề bài:
		 * 
		 * Viết chương trình lấy thời gian hiện tại ở múi giờ UTC và múi giờ của Việt
		 * Nam.
		 * 
		 * In ra định dạng yyyy-MM-dd HH:mm:ss.
		 * 
		 * Tính số giờ chênh lệch giữa hai múi giờ.
		 * 
		 * Gợi ý sử dụng: LocalDateTime.now(), ZonedDateTime.now(ZoneId.of(...)),
		 * DateTimeFormatter, Duration.between(...).
		 */
		// Ex 1
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
		DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		System.out.println(today.format(fm));
		System.out.println(tomorrow.format(fm));
		System.out.println(sevenDaysAgo.format(fm));

		// Ex2
		System.out.println("\nEx 2:");
		System.out.println(ZoneId.of("UTC"));
		LocalDateTime local = LocalDateTime.now();
		System.out.println(local);
		ZonedDateTime utcTime = local.atZone(ZoneId.of("UTC").systemDefault()).withZoneSameInstant(ZoneId.of("UTC"));
		System.out.println(utcTime);
		DateTimeFormatter ex2FM = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(local.format(ex2FM)+ " and " +utcTime.format(ex2FM));
		long hourBetween = Duration.between(local, utcTime).toHours();
		System.out.println(hourBetween);
		
		
	}
}
