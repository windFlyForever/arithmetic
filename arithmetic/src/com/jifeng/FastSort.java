package com.jifeng;

import java.util.Arrays;

/**
 * 快速排序
 * **/
public class FastSort {
	
	//拆分数组左边比key值小，右边比key值大
	public static int sperate_arr(int[] arr,int low ,int high) {
		//优化排序确保arr[mid]<=arr[low]<=arr[high]
		int mid=(low+high)/2;
		if(arr[mid]>arr[high]) {
			swap(arr, mid, high);
		}
		
		if(arr[low]>arr[high]) {
			swap(arr, low, high);			
		}
		
		if(arr[mid]>arr[low]) {
			swap(arr, low, mid);			
		}
		
		
		int key=arr[low];		
		while (low<high) {
			//从数组最后一位与key比较，比较arr[high]与key,直到arr[high]<key交换low与high值的位置
			while(low<high&&arr[high]>=key) high--;
			swap(arr, low, high);			
			//从数组high位置key值与low比较，比较arr[low]与key,直到arr[low]>key交换low与high值的位置			
			while(low<high&&arr[low]<=key) low++;
			swap(arr, low, high);
		}		
		return low;
	}
	
	
	public static void fast_sort(int[] arr,int low ,int high) {
		
		if(low<high) {
			int keypos=sperate_arr(arr, low, high);
			fast_sort(arr, low, keypos-1);
			fast_sort(arr, keypos+1, high);
		}		
	}
	
	public static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	
	public static void main(String[] args) {
		int arr[]= {10,1,6,-6,9,0,-7};		
		fast_sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));		
	}
	
	

}
