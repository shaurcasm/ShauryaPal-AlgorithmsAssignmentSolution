package com.shaurya.service.operations;

import com.shaurya.service.company.Company;
import com.shaurya.service.sorter.MergeSort;

public class Operations {

	String sorted;
	static final String ASCENDING = "ASCENDING";
	static final String DESCENDING = "DESCENDING";
	
	public void printAscending(Company companies[], int size) {
		
		MergeSort mergeSort = new MergeSort(true);
		mergeSort.sort(companies, 0, size - 1);
		
		System.out.println("Stock prices in ascending order are:");
		for(int i = 0; i < size; i++) {
			System.out.print(companies[i].getStock() + " ");
		}
		System.out.println();
		this.sorted = ASCENDING;
	}
	
	public void printDescending(Company companies[], int size) {
		MergeSort mergeSort = new MergeSort(false);
		mergeSort.sort(companies, 0, size - 1);
		
		System.out.println("Stock prices in descending order are:");
		for(int i = 0; i < size; i++) {
			System.out.print(companies[i].getStock() + " ");
		}
		System.out.println();
		
		this.sorted = DESCENDING;
	}
	
	public void printRising(Company companies[], int size) {
		int count = 0;
		
		for(int i = 0; i < size; i++) {
			if(companies[i].getPriceRose())
				count++;
		}
		System.out.println("Total no of companies whose stock price rose today: " + count);
	}
	
	public void printDeclining(Company companies[], int size) {
		int count = 0;
		
		for(int i = 0; i < size; i++) {
			if(!companies[i].getPriceRose())
				count++;
		}
		System.out.println("Total no of companies whose stock price declined today: " + count);
	}
	
	public void searchPrice(Company companies[], int size, double value) {
		int left = 0;
		int right = size - 1;
		int mid = left + (right - left) / 2;
		
		if(sorted != ASCENDING && sorted != DESCENDING)
		{
			// Merge sort in ascending if not sorted yet.
			MergeSort mergeSort = new MergeSort(true);
			mergeSort.sort(companies, left, right);
			
			this.sorted = ASCENDING;
		}
		
		while(left <= right) {
			if(sorted == ASCENDING) {
				if(value < companies[mid].getStock()) {
					right = mid - 1;
				} else if (value > companies[mid].getStock()) {
					left = mid + 1;
				} else {
					System.out.println("Stock of value " + value + " is present");
					break;
				}
			} else {
				if(value > companies[mid].getStock()) {
					right = mid - 1;
				} else if (value < companies[mid].getStock()) {
					left = mid + 1;
				} else {
					System.out.println("Stock of value " + value + " is present");
					break;
				}
			}
			
			mid = left + (right - left) / 2;
		}
		
		if (left > right) {
			System.out.println("Value not found");
		}
	}
}
