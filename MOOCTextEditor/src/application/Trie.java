package application;

import java.util.HashMap;

public class Trie<E> {
	
	private TrieNode<E> root;
	
	
	
	public class TrieNode<E> {
		
		//Does the word end a word?
		private boolean isWord;
		
		private String text;
		
		private HashMap<Character, TrieNode<E>> children;
		
	}
	

}
