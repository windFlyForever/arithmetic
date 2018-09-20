package com.jifeng;

import java.util.Arrays;

public class MergeSort {
	
	
	public static void merge_arr(int arr[],int low,int mid,int high) {
		int temp[]=new int[high-low+1];
		int i=low;
		int j=mid+1;
		int k=0;
		
		// 把较小的数先移到新数组中
		while(i<=mid&&j<=high) {
			if(arr[i]<arr[j]) {
				temp[k++]=arr[i++];
			}else {
				temp[k++]=arr[j++];
			}			
		}
		
		 // 把左边剩余的数移入数组 
		while(i<=mid) {
			temp[k++]=arr[i++];
		}
		
		// 把右边边剩余的数移入数组
		while(j<=high) {
			temp[k++]=arr[j++];
		}
		
		// 把新数组中的数覆盖nums数组
		for (int t = 0; t < temp.length; t++) {
			arr[low+t]=temp[t];
		}
	
	}
	
	
	public static void  merge_sort(int[] arr,int low ,int high) {
		int mid=(low+high)/2;		
		if(low<high) {
			merge_sort(arr, low, mid);
			merge_sort(arr, mid+1, high);
			//左右归并
			merge_arr(arr, low, mid, high);			
		}		
	}
	
	
	public static void main(String[] args) {
		int arr[]= {1,-5,8,9,4,6};
		
		merge_sort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
	}

}
