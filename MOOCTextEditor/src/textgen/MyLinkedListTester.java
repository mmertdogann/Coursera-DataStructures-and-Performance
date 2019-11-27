/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH = 10;

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
		shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);

	}

	/**
	 * Test if the get method is working correctly.
	 */
	/*
	 * You should not need to add much to this method. We provide it as an example
	 * of a thorough test.
	 */
	@Test
	public void testGet() {
		// test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}

		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));

		try {
			shortList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		// test longer list contents
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			assertEquals("Check " + i + " element", (Integer) i, longerList.get(i));
		}

		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

	}

	/**
	 * Test removing an element from the list. We've included the example from the
	 * concept challenge. You will want to add more tests.
	 */
	@Test
	public void testRemove() {
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer) 21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());

		// TODO: Add more tests here

		try {
			String removed = shortList.remove(-1);
			fail("Index cannot be negative");
		} catch (IndexOutOfBoundsException e) {

		}

		// Check upper bound
		try {
			String removed = shortList.remove(shortList.size());
			fail("Index cannot greater than the value");
		} catch (IndexOutOfBoundsException e) {

		}
	}

	/**
	 * Test adding an element into the end of the list, specifically public boolean
	 * add(E element)
	 */
	@Test
	public void testAddEnd() {
		boolean b = list1.add(20);
		assertEquals("Add empty list: check element 0", (Integer) 20, emptyList.get(0));
		assertEquals("Add empty list: check return value", true, b);
		assertEquals("Add empty list: check updated value", 1, emptyList.size());
		
		b = shortList.add("xyz");
      
        String[] expected = { "A", "B", "xyz" };
        String[] target = new String[expected.length];
        for (int i = 0; i < target.length; i++) {
            target[i] = shortList.get(i);
        }
        assertArrayEquals("Add non-empty list: contents", target, expected);
        assertEquals("Add non-empty list: return value", true, b);
        assertEquals("Add non-empty list: size", expected.length,
                shortList.size());

		// TODO: implement this test

	}

	/** Test the size of the list */
	@Test
	public void testSize() {
		// TODO: implement this test
        assertEquals(0, emptyList.size());
        emptyList.add(545);
        assertEquals(1, emptyList.size());
        emptyList.remove(0);
        assertEquals(0, emptyList.size());
	}

	/**
	 * Test adding an element into the list at a specified index, specifically:
	 * public void add(int index, E element)
	 */
	@Test
	public void testAddAtIndex() {
		// TODO: implement this test
        emptyList.add(0, 5);
        assertEquals("Test added element.", (Integer) 5, emptyList.get(0));
        assertEquals("Test the list size.", 1, emptyList.size());

	}

	/** Test setting an element in the list */
	@Test
	public void testSet() {
		// TODO: implement this test
		try {
            shortList.set(0, null);
            fail("Cannot be Null");
        } catch (NullPointerException e) {

        }

      
        try {
            shortList.set(-1, "asdas");
            fail("Index cannot be negative.");
        } catch (IndexOutOfBoundsException e) {

        }

        try {
            shortList.set(shortList.size(), "asdas");
            fail("Index cannot greater than size -1 ");
        } catch (IndexOutOfBoundsException e) {

        }

	}

	// TODO: Optionally add more test methods.

}
