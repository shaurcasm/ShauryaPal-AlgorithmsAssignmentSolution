package com.shaurya.service.sorter;

import com.shaurya.service.company.Company;

public class MergeSort {
	boolean isAscending;
	
	public MergeSort() {
		this.isAscending = true;
	}
	public MergeSort(boolean isAscending) {
		this.isAscending = isAscending;
	}

	public void sort(Company arr[], int start, int end) {
		if(start >= end)
			return;
		
		int partition = start + (end - start) / 2;
		sort(arr, start, partition);
		sort(arr, partition + 1, end);
		merge(arr, start, partition, end);
	}
	
	void merge(Company arr[], int left, int middle, int right) {
		int n1 = middle - left + 1;
		int n2 = right - middle;
		
		Company L[] = new Company[n1];
		Company R[] = new Company[n2];
		
		for(int i = 0; i < n1; i++)
			L[i] = arr[left + i];
		
		for(int j = 0; j < n2; j++)
			R[j] = arr[middle + j + 1];
		
		int i = 0, j = 0;
		int k = left;
		
		while(i < n1 && j < n2) {
			if(isAscending) {
				if(L[i].getStock() >= R[j].getStock()) {
					arr[k] = L[i];
					i++;
				} else {
					arr[k] = R[j];
					j++;
				}
			} else {
				if(L[i].getStock() <= R[j].getStock()) {
					arr[k] = L[i];
					i++;
				} else {
					arr[k] = R[j];
					j++;
				}
			}
			
			k++;
		}
		
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while(j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}
