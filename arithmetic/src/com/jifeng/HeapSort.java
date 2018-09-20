package com.jifeng;

import java.util.Arrays;

/**
 * 
 * ������
 **/
public class HeapSort {
	
	//����������Ҷ�ӽڵ㱣֤Ϊ�󶥶�
	public static void max_heap(int[] arr,int pos,int size) {
		int max_pos=pos;
		if(2*pos+1<size&&arr[2*pos+1]>arr[max_pos]) {			
			max_pos=2*pos+1;
		}
		
		if(2*pos+2<size&&arr[2*pos+2]>arr[max_pos]) {			
			max_pos=2*pos+2;
		}
		
		if(max_pos!=pos) {
			int temp=arr[pos];
			arr[pos]=arr[max_pos];
			arr[max_pos]=temp;
			max_heap(arr, max_pos, size);
		}
	}
	
	//��������󶥶�
	public static void build_max_heap(int[] arr,int size) {		
		for (int i = size/2-1; i >=0; i--) {
			max_heap(arr, i, size);
		}		
	}
	
	
	//������
	public static void heap_sort(int[] arr,int size) {	
		//�����󶥶�
		build_max_heap(arr, size);
		for (int i = size; i > 0; i--) {
			int temp=arr[0];
			arr[0]=arr[i-1];
			arr[i-1]=temp;
			max_heap(arr, 0, i-1);//�Ѷ���ֵ�ı���Ҫ��ʣ��������¹����󶥶�
		}		
	}	
	
	public static void main(String[] args) {
		int arr[]= {1,6,-6,9,0,-7};		
		heap_sort(arr, arr.length);		
		System.out.println(Arrays.toString(arr));
	}
	
}
