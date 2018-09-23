package com.jifeng;

import java.nio.charset.MalformedInputException;

//临接矩阵构造图
public class Graph {
	
	private int[][] edgeValues=new int[105][105] ;//表示边权值
	private int nodeCount;//节点数量
		
	//求最小生成树prim算法	
	public static int prim(Graph g,int[] parent) {
		int visit[]=new int[105];
		int min_distance[]=new int[105];
		int closest[]=new int[105];
		
		int i,j,min,min_pos,min_value=0;
		
		for (i = 0; i < g.nodeCount; i++) {
			min_distance[i]=g.edgeValues[0][i];//初始化第i个节点到第一个节点的距离
			//parent[i]=-1;
			closest[i]=g.edgeValues[0][i]>0?0:-1;//初始化第i个节点到第一个节点的是否联通			
		}
		//以第一个节点开始更新最小距离
		visit[0]=1;//设第一个节点已被访问
		for (i = 0; i < g.nodeCount-1; i++) {
			min_pos=-1;
			min=-1;
			//查找剩余未访问节点中距离最小的节点
			for (j = 1; j< g.nodeCount; j++) {
				if(visit[j]==0&&min_distance[j]>0&&(min==-1||min>min_distance[j])) {
					min=min_distance[j];
					min_pos=j;
				}
			}
			//当剩余节点和当前生成树无法相连时，图不连通，无法构成生成树
			if(min_pos==-1) {
				return -1;
			}
			visit[min_pos]=1;//标记当前最近节点已被访问
			//parent[min_pos]=closest[min_pos];
			min_value+=min;
			//min_value+=g.edgeValues[min_pos][parent[min_pos]];
			
			//加入新节点更新各节点最小距离
			for (j  = 0; j < g.nodeCount; j++) {
				
				if(visit[j]==0&&g.edgeValues[min_pos][j]>=0&&(min_distance[j]==-1||min_distance[j]>g.edgeValues[min_pos][j])) {
					min_distance[j]=g.edgeValues[min_pos][j];
					closest[j]=min_pos;					
				}
			}
			
		}
		
		return min_value;
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
		System.out.println(value);
		
	}
	
	
	public static void initArray(int[][] arr,int value) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j]=value;
			}
		}
		
		
	}

}
