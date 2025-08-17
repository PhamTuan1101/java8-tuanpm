package com.dd.tuanpm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Product {
	private int id;
	private String name;
	private int categoryId;
	private Date saleDate;
	private int qulity;
	private boolean isDelete;

	public Product() {
	}

	public Product(int id, String name, int categoryId, Date saleDate, int qulity, boolean isDelete) {
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.saleDate = saleDate;
		this.qulity = qulity;
		this.isDelete = isDelete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public int getqulity() {
		return qulity;
	}

	public void setqulity(int qulity) {
		this.qulity = qulity;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "Product{" + "id=" + id + ", name='" + name + '\'' + ", categoryId=" + categoryId + ", saleDate="
				+ saleDate + ", quality=" + qulity + ", isDelete=" + isDelete + '}';
	}
	
	//EX10
	public static List<Product> createProducts() {
		List<Product> products = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			 products.add(new Product(2, "Samsung", 1, sdf.parse("2025-08-10"), 0, false));
		        products.add(new Product(3, "Oppo", 2, sdf.parse("2025-08-17"), 5, false));
		        products.add(new Product(4, "Xiaomi", 2, sdf.parse("2025-08-20"), 8, true));
		        products.add(new Product(5, "Asus", 3, sdf.parse("2025-08-12"), 12, false));
		        products.add(new Product(6, "HP", 3, sdf.parse("2025-08-17"), 0, false));
		        products.add(new Product(7, "Dell", 3, sdf.parse("2025-08-20"), 4, false));
		        products.add(new Product(8, "Lenovo", 3, sdf.parse("2025-08-10"), 6, false));
		        products.add(new Product(9, "Macbook", 3, sdf.parse("2025-08-17"), 3, false));
		        products.add(new Product(10, "Surface", 3, sdf.parse("2025-08-25"), 2, false));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return products;
	}

	//EX11
	// 1. Dùng Stream
	public static void filterProductByIdStream(List<Product> list, int id) {
	    list.stream()
        .filter(p -> p.getId() == id)
        .map(Product::getName)                 
        .forEach(System.out::println); 
	}

	// 2. Không dùng Stream
	public static String filterProductWithOutStream(List<Product> list, int id) {
		for (Product p : list) {
			if (p.getId() == id)
				return p.getName();
		}
		return null;
	}
	
	//EX12
	// Stream
	public static List<Product> filterProductByQuantityStream(List<Product> list) {
	    return list.stream()
	            .filter(p -> p.getqulity() > 0 && !p.isDelete())
	            .collect(Collectors.toList());
	}

	// Không Stream
	public static List<Product> filterProductByQuantityNormal(List<Product> list) {
	    List<Product> result = new ArrayList<>();
	    for (Product p : list) {
	        if (p.getqulity() > 0 && !p.isDelete()) {
	            result.add(p);
	        }
	    }
	    return result;
	}
	
	//EX13
	// Stream
	public static List<Product> filterProductBySaleDateStream(List<Product> list) {
	    Date now = new Date();
	    return list.stream()
	            .filter(p -> p.getSaleDate().after(now) && !p.isDelete())
	            .collect(Collectors.toList());
	}

	// Không Stream
	public static List<Product> filterProductBySaleDateNormal(List<Product> list) {
	    Date now = new Date();
	    List<Product> result = new ArrayList<>();
	    for (Product p : list) {
	        if (p.getSaleDate().after(now) && !p.isDelete()) {
	            result.add(p);
	        }
	    }
	    return result;
	}

	//EX14
	// Stream (dùng reduce)
	public static int totalProductStream(List<Product> list) {
	    return list.stream()
	            .filter(p -> !p.isDelete())
	            .map(Product::getqulity)
	            .reduce(0, Integer::sum);
	}

	// Không reduce
	public static int totalProductNormal(List<Product> list) {
		return list.stream()
		        .filter(p -> !p.isDelete())
		        .mapToInt(Product::getqulity)
		        .sum();

	}
	
	//EX15
	// Stream
	public static boolean isHaveProductInCategoryStream(List<Product> list, int categoryId) {
	    return list.stream().anyMatch(p -> p.getCategoryId() == categoryId);
	}

	// Không Stream
	public static boolean isHaveProductInCategoryNormal(List<Product> list, int categoryId) {
	    for (Product p : list) {
	        if (p.getCategoryId() == categoryId) return true;
	    }
	    return false;
	}

	//EX16
	// Stream
	public static List<String> filterProductBySaleDateAndQuantityStream(List<Product> list) {
	    Date now = new Date();
	    return list.stream()
	            .filter(p -> p.getSaleDate().after(now) && p.getqulity() > 0)
	            .map(p -> "(" + p.getId() + ", " + p.getName() + ")")
	            .collect(Collectors.toList());
	}

	// Không Stream
	public static List<String> filterProductBySaleDateAndQuantityNormal(List<Product> list) {
	    Date now = new Date();
	    List<String> result = new ArrayList<>();
	    for (Product p : list) {
	        if (p.getSaleDate().after(now) && p.getqulity() > 0) {
	            result.add("(" + p.getId() + ", " + p.getName() + ")");
	        }
	    }
	    return result;
	}

	public static void main(String[] args) {
	    List<Product> list = createProducts();

	    System.out.println("=== EX11: Filter by Id ===");
	    System.out.print("Stream: ");
	    filterProductByIdStream(list, 3);
	    System.out.println("Normal: " + filterProductWithOutStream(list, 3));

	    System.out.println("\n=== EX12: Filter by Quantity > 0 & not deleted ===");
	    System.out.println("Stream: " + filterProductByQuantityStream(list));
	    System.out.println("Normal: " + filterProductByQuantityNormal(list));

	    System.out.println("\n=== EX13: Filter by SaleDate > now & not deleted ===");
	    System.out.println("Stream: " + filterProductBySaleDateStream(list));
	    System.out.println("Normal: " + filterProductBySaleDateNormal(list));

	    System.out.println("\n=== EX14: Total quantity (not deleted) ===");
	    System.out.println("Stream (reduce): " + totalProductStream(list));
	    System.out.println("Stream (mapToInt-sum): " + totalProductNormal(list));

	    System.out.println("\n=== EX15: Check product in category ===");
	    System.out.println("Stream: " + isHaveProductInCategoryStream(list, 2));
	    System.out.println("Normal: " + isHaveProductInCategoryNormal(list, 2));

	    System.out.println("\n=== EX16: Filter by SaleDate > now & quantity > 0 ===");
	    System.out.println("Stream: " + filterProductBySaleDateAndQuantityStream(list));
	    System.out.println("Normal: " + filterProductBySaleDateAndQuantityNormal(list));
	}
}
