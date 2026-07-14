package com.inventorymgmt;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner (System.in);
		ProductDAO dao=new ProductDAOImpl();
		
		int choice;
		do {
			System.out.println("===================PRODUCT INVENTORY MANAGEMENT SYSTEM====================");
			System.out.println("1.Add Product");
			System.out.println("2.Update Product");
			System.out.println("3.Delete Product");
			System.out.println("4.Search Product");
			System.out.println("5.Display All Products");
			System.out.println("6.Exit");
			System.out.println("Enter your choice:");
			System.out.println();
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				Product p1=new Product();
				System.out.println("Enter product id:");
				p1.setId(sc.nextInt());
				sc.nextLine();
				
				System.out.println("Enter name:");
				p1.setName(sc.nextLine());
				
				System.out.println("Enter category:");
				p1.setCategory(sc.nextLine());
				
				System.out.println("Enter price:");
				p1.setPrice(sc.nextDouble());
				sc.nextLine();
				
				System.out.println("Enter stock:");
				p1.setStock(sc.nextInt());
				sc.nextLine();
				
				dao.addProduct(p1);
				
				break;
				
			case 2:
				Product p2=new Product();
				System.out.println("Enter Product id:");
				p2.setId(sc.nextInt());
				sc.nextLine();
				
				System.out.println("Enter New name:");
				p2.setName(sc.nextLine());
				
				System.out.println("Enter New category:");
				p2.setCategory(sc.nextLine());
				
				System.out.println("Enter New price:");
				p2.setPrice(sc.nextDouble());
				sc.nextLine();
				
				System.out.println("Enter New stock:");
				p2.setStock(sc.nextInt());
				sc.nextLine();
				
				dao.updateProduct(p2);
				
				break;
			 case 3:
	                System.out.print("Enter Product ID to Delete: ");
	                int deleteID=sc.nextInt()
;	                dao.deleteProduct(deleteID);
	                break;

	            case 4:
	                System.out.print("Enter Product ID to Search: ");
	                int id = sc.nextInt();

	                Product p = dao.searchProduct(id);

	                if (p != null) {
	                    System.out.println("\n----- Product Details -----");
	                    System.out.println("ID       : " + p.getId());
	                    System.out.println("Name     : " + p.getName());
	                    System.out.println("Category : " + p.getCategory());
	                    System.out.println("Price    : " + p.getPrice());
	                    System.out.println("Stock    : " + p.getStock());
	                } else {
	                    System.out.println("Product not found!");
	                }
	                break;

	            case 5:
	                List<Product> list = dao.displayAllProducts();

	                if (list.isEmpty()) {
	                    System.out.println("No Records Found!");
	                } else {

	                    System.out.println("\n---------------- Product List ----------------");
	                    System.out.printf("%-5s %-20s %-15s %-10s %-10s\n",
	                            "ID", "NAME", "CATEGORY", "PRICE", "STOCK");
	                    System.out.println("--------------------------------------------------------------------------");

	                    for (Product prod : list) {
	                        System.out.printf("%-5d %-20s %-15s %-10.2f %-10d\n",
	                                prod.getId(),
	                                prod.getName(),
	                                prod.getCategory(),
	                                prod.getPrice(),
	                                prod.getStock());
	                    }
	                }
	                break;

	            case 6:
	                System.out.println("Thank You! Exiting Product Inventory Management System...");
	                break;

	            default:
	                System.out.println("Invalid Choice! Please Try Again.");
	            }

	        } while (choice != 6);

	        sc.close();
	    }
	}