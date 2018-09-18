package com.jifeng;

import java.util.Arrays;

public class FastSort {
	
	//���������߱�keyֵС���ұ߱�keyֵ��
	public static int sperate_arr(int[] arr,int low ,int high) {
		int key=arr[low];		
		while (low<high) {
			//���������һλ��key�Ƚϣ��Ƚ�arr[high]��key,ֱ��arr[high]<key����low��highֵ��λ��
			while(low<high&&arr[high]>=key) high--;
			int temp=arr[high];
			arr[high]=arr[low];
			arr[low]=temp;			
			//������highλ��keyֵ��low�Ƚϣ��Ƚ�arr[low]��key,ֱ��arr[low]>key����low��highֵ��λ��			
			while(low<high&&arr[low]<=key) low++;
			int templow=arr[low];
			arr[low]=arr[high];
			arr[high]=templow;
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
	
	public static void main(String[] args) {
		int arr[]= {1,6,-6,9,0,-7};
		
		fast_sort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	

}
