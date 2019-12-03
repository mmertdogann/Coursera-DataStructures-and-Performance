package application;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> {
	
	TreeNode<E> root;
	
	public boolean insert(E value) {
		
		TreeNode<E> curr = root;
		//if this object less than the parameter returns value < 0
		int comp = toFind.compareTo(curr.getData());
		
		while (comp < 0 && curr.getLeft != null || com > 0 && curr.getRight != null) {
			
			if (comp < 0) curr = curr.getLeft();
			else curr = curr.getRight();
			comp = value.compareTo(curr.getData());
			
		}
		
		if (comp < 0)
			curr.setLeftChild(value, curr);
		else if (comp > 0)
			curr.setRightChild(value, curr);
		else return false;
		
		return true;
	
	}
	
	public boolean contains(E toFind) {
		TreeNode<E> curr = root;
		
		while (curr != null) {
			
			//if this object less than the parameter returns value < 0
			int comp = toFind.compareTo(curr.getData());
		
			if (comp < 0)
				curr = curr.getLeft();
			else if (comp > 0)
				curr = curr.getRight();
			else
				return true;
			
			}
		return false;
	}
	
	
	private void preOrder(TreeNode <E> node) {
		if(node!= null) {
			node.visit();
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}
	public void preOrder() {
		this.preOrder(root);
	}
	
	public void levelOrder() {
		Queue<  TreeNode<E> > q = new LinkedList<  TreeNode<E> >();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode<E> curr = q.remove();
			if(curr != null) {
				curr.visit();
				q.add(curr.getLeftChild());
				q.add(curr.getRightChild());
			}
		}
	}
	

	
	private class TreeNode<E> {
		
		private E value;
		private TreeNode<E> parent;
		private TreeNode<E> left;
		private TreeNode<E> right;
		
		public TreeNode(E val, TreeNode<E> par) {
			
			this.value = val;
			this.parent = par;
			//For root: TreeNode(val,null)
			this.left = null;
			this.right = null;
		}
		
		public TreeNode<E> addLeftChild(E val) {
			this.left = new TreeNode<E>(val, this);
			return this.left;
		}
		
		
	}
	
	

}
