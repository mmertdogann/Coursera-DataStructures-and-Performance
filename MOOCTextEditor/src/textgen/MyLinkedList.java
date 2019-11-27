package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.size = 0;
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * 
	 * @param element The element to add
	 */
	public boolean add(E element) {

		if (element == null) {
			throw new NullPointerException("Cannot add null elements");
		}

		LLNode<E> node = new LLNode<E>(element);

		node.next = tail;
		node.prev = tail.prev;
		tail.prev.next = node;
		tail.prev = node;

		size++;

		return true;
	}

	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E get(int index) throws IndexOutOfBoundsException {

		E returned = null;
		if (size == 0 || index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Index out of bounds in get() method");
		}

		LLNode<E> node = head.next;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}

		returned = node.data;
		return returned;

	}

	/**
	 * Add an element to the list at the specified index
	 * 
	 * @param The     index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element) {
		// TODO: Implement this method

		if (element == null) {
			throw new NullPointerException("'Data can not be null");
		}

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		LLNode<E> n = new LLNode<E>(element);
		LLNode<E> c = head;

		int i = 0;
		while (c.next.data != null) {
			if (i == index) {
				n.prev = c.prev;
				n.next = c;
				c.prev.next = n;
				c.prev = n;
			}
			c = c.next;
			i++;
		}

		size++;
	}

	/** Return the size of the list */
	public int size() {

		// TODO: Implement this method
		return this.size;
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 * 
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) {
		// TODO: Implement this method

		if (index < 0 || index > this.size() - 1) {
			throw new IndexOutOfBoundsException("Not acceptable index.");
		}

		LLNode<E> c = head;
		E returned = null;
		int i = 0;
		while (c.next.data != null) {
			if (i == index) {
				returned = c.data;
				c.next.prev = c.prev;
				c.prev.next = c.next;

			}
			c = c.next;
			i++;
		}

		size--;
		return returned;
	}

	/**
	 * Set an index position in the list to a new element
	 * 
	 * @param index   The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) {
		// TODO: Implement this method
		
	    if (element == null) {
	      throw new NullPointerException("'Data should not be null!");
	    }
	    
	    if (index < 0 || index > this.size() - 1) {
	      throw new IndexOutOfBoundsException("Index cannot less than or equal zero");
	    }
		
		
		LLNode<E> c = head;

		int i = 0;
		while (c.next.data != null) {
			if (i == index) {
				c.data = element;
			}
			c = c.next;
			i++;
		}
		return element;
	}
}

class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
