package com.jifeng;

import java.nio.charset.Charset;

public class Kmp {
	
	
	
	public static int matchString(char[] s1,char s2[]) {
		int len1=s1.length;
		int len2=s2.length;
		int i,j,k;
		for (i = 0; i <len1; i++) {
			k=i;
			j=0;
			while(k<len1&&j<len2&&s1[k]==s2[j]) {				
				k++;
				j++;
			}
			
			if(j==len2) {
				
				return i;
			}			
		}
		
		return -1;
	}
	
	
	//构架kmp的next的数组
	
	public static void build_next(char str[],int next[]) {
		
		next[0]=0;
		
		int q,k=0,j=1;
		int len=str.length;
		
		while(j<len) {
			if(k==0||str[j]==str[k]) {
				next[j++]=k++;
			}else {
				k=next[k];
			}	
		}
	}
	
	//kmp算法
	public static int kmp(char s1[],char s2[]) {
		int len1=s1.length;
		int len2=s2.length;
		int next[]=new int[105];
		build_next(s2, next);
		int i,j=0;
		for (i = 0; i < len1; i++) {
			
			while(j>0&&s1[i]!=s2[j]) {				
				j=next[j];				
			}//当不匹配时
			
			if(s1[i]==s2[j]) {
				j++;
			}
			if(j==len2) {
				return i-j;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		String s1="agbcdg";
		
		String s2="g";
	
		int[] i= {1,3,4};
		System.out.println(i['b'-'a']);
		
		System.out.println(kmp(s1.toCharArray(), s2.toCharArray()));
	}

}
