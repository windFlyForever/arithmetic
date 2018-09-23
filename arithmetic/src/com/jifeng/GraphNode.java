package com.jifeng;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//临接表构造图
public class GraphNode implements Comparable<GraphNode>{
	
	
	private int label;//图顶点的值
	
	private List<GraphNode> neighbors=new LinkedList<GraphNode>();
	
	
	public GraphNode() {
		
	}

	public GraphNode(int label) {
		super();
		this.label = label;
	}
	
	//创建图
	public static GraphNode[]  buildGraph() {
		GraphNode[] graph=new GraphNode[5];
		for (int i = 0; i < graph.length; i++) {
			graph[i]=new GraphNode(i);
		}		
		graph[0].neighbors.add(graph[2]);
		graph[0].neighbors.add(graph[4]);
		graph[1].neighbors.add(graph[0]);
		graph[1].neighbors.add(graph[2]);
		graph[2].neighbors.add(graph[3]);
		graph[3].neighbors.add(graph[4]);
		graph[4].neighbors.add(graph[3]);	
		
		for (int i = 0; i < graph.length; i++) {
			System.out.println(graph[i].label+"\n");
			for (int j = 0; j < graph[i].neighbors.size(); j++) {
				System.out.print("\t"+graph[i].neighbors.get(j).label);
			}	
			System.out.println("\n");
		}
		return graph;
	}
	
	//深度优先遍历图
	public static void DFS_graph(GraphNode node,int visit[]) {
		//标记已访问的节点
		visit[node.label]=1;
		System.out.println(node.label);
		for (int i = 0; i < node.neighbors.size(); i++) {
			if(visit[node.neighbors.get(i).label]==0) {
				DFS_graph(node.neighbors.get(i),visit);
			}			
		}		
	}
	
	
	//宽度优先遍历图
	public static void BFS_graph(GraphNode node,int visit[]) {
		Queue<GraphNode> que=new PriorityQueue<GraphNode>();
		que.add(node);
		//标记已访问的节点
		visit[node.label]=1;		
		while (!que.isEmpty()) {
			GraphNode firstnode=que.peek();//取得队列头元素
			System.out.println(firstnode.label);
			que.poll();			
			for (int i = 0; i < firstnode.neighbors.size(); i++) {
				if(visit[firstnode.neighbors.get(i).label]==0) {						
					que.add(firstnode.neighbors.get(i));				
					visit[firstnode.neighbors.get(i).label]=1;
				} 
			}			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		//深度优先遍历测试
		GraphNode[] nodes=buildGraph();
		int MAX_N=5;//nodes中节点label值最大
		int visit[]=new int[MAX_N];		
		for (int i = 0; i < visit.length; i++) {
			if(visit[i]==0) {				
				BFS_graph(nodes[i], visit);				
			}
		}
		
	}

	@Override
	public int compareTo(GraphNode o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	

}
