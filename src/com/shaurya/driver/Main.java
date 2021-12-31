package com.shaurya.driver;

import java.util.Scanner;
import com.shaurya.service.company.*;
import com.shaurya.service.operations.Operations;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Operations op = new Operations();

		System.out.println("Enter the no of companies");
		int size = sc.nextInt();
		Company companies[] = new Company[size];
		for(int i = 0; i < size; i++)
			companies[i] = new Company();
		
		for(int i = 0; i < size; i++) {
			System.out.println("Enter current stock price of the company " + (i + 1));
			companies[i].setStock(sc.nextDouble());
			
			System.out.println("Whether company's stock price rose today compared to yesterday?");
			companies[i].setPriceRose(sc.nextBoolean());
		}
		
		int choice = 1;
		
		while (choice != 0 || choice != 6) {
			System.out.println("---");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. Press 0 to exit");
			System.out.println("---");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				op.printAscending(companies, size);
				break;
			case 2:
				op.printDescending(companies, size);
				break;
			case 3:
				op.printRising(companies, size);
				break;
			case 4:
				op.printDeclining(companies, size);
				break;
			case 5:
				System.out.println("Enter the key value");
				double value = sc.nextDouble();
				op.searchPrice(companies, size, value);
				break;
			case 0:
			case 6:
				System.out.println("Exited successfully");
				sc.close();
				System.exit(0);
				break;
				
			default:
				System.out.println("Choose from the options");
			}
			
			System.out.println();
		};
		
		sc.close();
		System.exit(0);
	}

}
 