package com.jifeng;



public class TreeNode {
	
	private TreeNode left;
	private TreeNode right;	
	private int value;
	
	
	
	public TreeNode() {
		super();
	}

	public TreeNode(TreeNode left, TreeNode right, int value) {
		super();
		this.left = left;
		this.right = right;
		this.value = value;
	}
	
	

	public TreeNode(int value) {
		super();
		this.value = value;
	}

	public static void preOrder(TreeNode node) {		
		if(node!=null) {
			System.out.print(node.value+"\t");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public static void midOrder(TreeNode node) {		
		if(node!=null) {			
			midOrder(node.left);
			System.out.println(node.value);
			midOrder(node.right);
		}
	}
	
	public static void postOrder(TreeNode node) {		
		if(node!=null) {			
			postOrder(node.left);
			
			postOrder(node.right);
			System.out.println(node.value);
		}
	}
	
	//二叉查找树搜索操作
	public static TreeNode search(TreeNode node,int value,TreeNode parent) {		
		if(node.value==value) {			
			return node;
		}
		parent=node;
		if(node.value>value) {
			if(node.left!=null) {
				return search(node.left, value,parent);
			}else {
				return null;
			}			
		}else {
			if(node.right!=null) {
				return search(node.right, value,parent);
			}else {
				return null;
			}
		}
	}
	
	//二叉查找树插入操作
	public static void insert(TreeNode node,TreeNode insertnode) {		
		
		if(node.value>insertnode.value) {
			if(node.left!=null) {
				insert(node.left, insertnode);
			}else {
				node.left=insertnode;				
			}			
		}else {
			if(node.right!=null) {
				insert(node.right, insertnode);
			}else {
				node.right=insertnode;				
			}
		}
	}
	
	//删除只有1个或者0个子节点的节点
	public static void delete_node(TreeNode parent,TreeNode node) {
		if(parent.value>node.value) {
			if(node.left!=null&&node.right==null) {
				parent.left=node.left;
			}else if(node.left==null&&node.right!=null) {
				parent.left=node.right;
			}else {
				parent.left=null;
			}
		}else if(parent.value<node.value){
			if(node.left!=null&&node.right==null) {
				parent.right=node.left;
			}else if(node.left==null&&node.right!=null) {
				parent.right=node.right;
			}else {
				parent.right=null;
			}			
		}		
	}
	
	//查找当前节点的后继节点
	public static TreeNode find_successor(TreeNode node,TreeNode parent) {
		parent=node;
		TreeNode ptr=node.right;
		while(ptr.left!=null) {
			parent=ptr;
			ptr=ptr.left;			
		}
		return ptr;
	}
	
	
	public static TreeNode deleteNode(TreeNode root,int  key) {
		TreeNode parent=null;
		TreeNode node=search(root, key, parent);
		if(node==null) {
			return root;
		}
		
		if(node.left!=null&&node.right!=null) {
			TreeNode successor=find_successor(node, parent);
			delete_node(parent, successor);
			node.value=successor.value;
			return root;
		}
		
		if(node.left==null&&node.right==null||(node.left!=null&&node.right==null)||(node.left==null&&node.right!=null)) {
			delete_node(parent, node);
			return root;
		}
		
		//删除节点是根节点且有一个子节点
		if(node==root&&node.left!=null&&node.right==null) {			
			root=node.left;
		}else {
			
			root=node.right;
		}		
		return root;
		
	}
	
	
	
	public static TreeNode buildTree(int arr[],int size) {
		TreeNode root=new TreeNode(arr[0]);
		
		for (int i = 1; i < size; i++) {
			TreeNode insertnode=new TreeNode(arr[i]);
			insert(root, insertnode);
		}		
		return root;		
	}
	
	//二叉搜索树排序
	public static void TreeSort(int arr[]) {
		//创建二叉搜索树
		TreeNode root=buildTree(arr, arr.length);
		//中序遍历得到排序结果
		midOrder(root);
	}
	
	
	
	public static void main(String[] args) {
		
		int[] arr= {8,10,3,6,1,15};		
		TreeSort(arr);
	}
	
	
	

}
