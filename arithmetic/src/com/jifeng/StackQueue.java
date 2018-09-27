package com.jifeng;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {
	
	
	
	public static boolean check_is_valid(Queue<Integer> que) {
		Stack<Integer> stack=new Stack();
		for (int i = 1; i <=que.size(); i++) {
			stack.push(i);			
			while(!stack.isEmpty()&&que.peek()==stack.peek()) {
				que.poll();
				stack.pop();
			}
		}
		if(stack.isEmpty()) {
			return true;
		}		
		return false;
	}
	
	
	public static void main(String[] args) {
		Queue<Integer> que=new PriorityQueue<Integer>();
		que.add(1);
		que.add(2);
		que.add(3);
	
		que.add(4);
		que.add(5);
		for (Integer integer : que) {
			System.out.println(integer);
		}
		System.out.println(check_is_valid(que));
	}

}
