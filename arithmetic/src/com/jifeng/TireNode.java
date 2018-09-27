package com.jifeng;

public class TireNode {
	
	
	private int isEnd;
	
	private TireNode[] nodes=new TireNode[26];

	public TireNode() {
	}

	public TireNode(int isEnd) {
		super();
		this.isEnd = 0;
	}
	
	public static void StringInsert(TireNode root,char[] s) {
		TireNode p=root;
		
		for (int i = 0; i < s.length; i++) {
			if(p.nodes[s[i]-'a']==null) {
				TireNode newNode=new TireNode();
				p.nodes[s[i]-'a']=newNode;
			}
		}
		
	}
	
	
	
	

}
