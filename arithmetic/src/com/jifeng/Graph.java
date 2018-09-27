package com.jifeng;

import java.nio.charset.MalformedInputException;

//�ٽӾ�����ͼ
public class Graph {
	
	private int[][] edgeValues=new int[105][105] ;//��ʾ��Ȩֵ
	private int nodeCount;//�ڵ�����
		
	//����С������prim�㷨	
	public static int prim(Graph g,int[] parent) {
		int visit[]=new int[105];
		int min_distance[]=new int[105];
		int closest[]=new int[105];
		
		int i,j,min,min_pos,min_value=0;
		
		for (i = 0; i < g.nodeCount; i++) {
			min_distance[i]=g.edgeValues[0][i];//��ʼ����i���ڵ㵽��һ���ڵ�ľ���
			//parent[i]=-1;
			closest[i]=g.edgeValues[0][i]>0?0:-1;//��ʼ����i���ڵ㵽��һ���ڵ���Ƿ���ͨ			
		}
		//�Ե�һ���ڵ㿪ʼ������С����
		visit[0]=1;//���һ���ڵ��ѱ�����
		for (i = 0; i < g.nodeCount-1; i++) {
			min_pos=-1;
			min=-1;
			//����ʣ��δ���ʽڵ��о�����С�Ľڵ�
			for (j = 1; j< g.nodeCount; j++) {
				if(visit[j]==0&&min_distance[j]>0&&(min==-1||min>min_distance[j])) {
					min=min_distance[j];
					min_pos=j;
				}
			}
			//��ʣ��ڵ�͵�ǰ�������޷�����ʱ��ͼ����ͨ���޷�����������
			if(min_pos==-1) {
				return -1;
			}
			visit[min_pos]=1;//��ǵ�ǰ����ڵ��ѱ�����
			//parent[min_pos]=closest[min_pos];
			min_value+=min;
			//min_value+=g.edgeValues[min_pos][parent[min_pos]];
			
			//�����½ڵ���¸��ڵ���С����
			for (j  = 0; j < g.nodeCount; j++) {
				
				if(visit[j]==0&&g.edgeValues[min_pos][j]>=0&&(min_distance[j]==-1||min_distance[j]>g.edgeValues[min_pos][j])) {
					min_distance[j]=g.edgeValues[min_pos][j];
					closest[j]=min_pos;					
				}
			}
			
		}
		
		return min_value;
	}
	
	
	
	//�Ͻ�˹�����㷨	
		public static int dijkstra(Graph g,int start,int finish) {
			int visit[]=new int[105];
			int min_distance[]=new int[105];					
			int i,j,min,min_pos=0;
			
			for (i = 0; i < g.nodeCount; i++) {
				min_distance[i]=g.edgeValues[start][i];
				
			}
			
			visit[0]=1;
			min_distance[0]=0;

			for (i = 0; i < g.nodeCount; i++) {
				min_pos=-1;
				min=-1;
				
				for (j = 0; j< g.nodeCount; j++) {
					if(visit[j]==0&&min_distance[j]>0&&(min==-1||min>min_distance[j])) {
						min=min_distance[j];
						min_pos=j;
					}
				}
				//��ʣ��ڵ�͵�ǰ�������޷�����ʱ��ͼ����ͨ���޷�����������
				if(min_pos==-1) {
					break;
				}
				visit[min_pos]=1;
				
				
				for (j  = 0; j < g.nodeCount; j++) {
					
					if(visit[j]==0&&g.edgeValues[min_pos][j]>=0&&(min_distance[j]<0||min_distance[j]>(g.edgeValues[min_pos][j]+min_distance[min_pos]))) {
						min_distance[j]=g.edgeValues[min_pos][j]+min_distance[min_pos];
									
					}
				}
				
			}
			
			return min_distance[finish];
		}
		
		
		
		
		public static void floyd(Graph g) {
			int i,j,k=0;
			
			for (k = 0; k < g.nodeCount; k++) {
				for (i = 0; i < g.nodeCount; i++) {
					
					if(k==i)  continue;
					
					for (j = 0; j < g.nodeCount; j++) {
						if(i!=j&&j!=k&&g.edgeValues[i][j]>g.edgeValues[i][k]+g.edgeValues[k][j]) {
							g.edgeValues[i][j]=g.edgeValues[i][k]+g.edgeValues[k][j];
						}
					}
					
				}	
			}
			
			for (i = 0; i< g.nodeCount; i++) {
				for (j = i+1; j < g.nodeCount; j++) {
					System.out.println("Node"+i+"----"+"Node"+j+"����С����Ϊ��"+g.edgeValues[i][j]);
				}
			}
		}
	
	
	public static void main(String[] args) {
		Graph g=new Graph();
		int[][] ge=g.edgeValues;
		initArray(ge, -1);
		g.nodeCount=6;
		
		g.edgeValues[0][1]=g.edgeValues[1][0]=6;
		g.edgeValues[0][2]=g.edgeValues[2][0]=1;
		g.edgeValues[0][3]=g.edgeValues[3][0]=5;
		g.edgeValues[1][2]=g.edgeValues[2][1]=5;
		g.edgeValues[3][2]=g.edgeValues[2][3]=5;
		g.edgeValues[4][2]=g.edgeValues[2][4]=6;		
		g.edgeValues[4][1]=g.edgeValues[1][4]=3;
		g.edgeValues[5][2]=g.edgeValues[2][5]=4;		
		g.edgeValues[5][3]=g.edgeValues[3][5]=2;
		g.edgeValues[5][4]=g.edgeValues[4][5]=6;
		int value=prim(g,new  int[105]);
		int dvalue=dijkstra(g, 0, 4);
		System.out.println(value);
		System.out.println(dvalue);
		
		
	}
	
	
	public static void initArray(int[][] arr,int value) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j]=value;
			}
		}
		
		
	}

}
