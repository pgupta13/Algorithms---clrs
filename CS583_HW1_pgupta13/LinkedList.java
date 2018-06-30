

import java.util.Collection;

import CS583.MergeSortHW1;

public class LinkedList {
	
	
	
	int modCount = 0;

	transient int size = 0;

	/**
	 * Pointer to first node. Invariant: (first == null && last == null) ||
	 * (first.prev == null && first.item != null)
	 */
	transient Node<Integer> first;

	/**
	 * Pointer to last node. Invariant: (first == null && last == null) ||
	 * (last.next == null && last.item != null)
	 */
	transient Node<Integer> last;

	public LinkedList() {
	}

	void linkLast(Integer e) {
		final Node<Integer> l = last;
		final Node<Integer> newNode = new Node<>(l, e, null);
		last = newNode;
		if (l == null)
			first = newNode;
		else
			l.next = newNode;
		size++;
		modCount++;
	}

	public int size() {
		return size;
	}

	/**
	 * Appends the specified element to the end of this list.
	 *
	 * <p>
	 * This method is equivalent to {@link #addLast}.
	 *
	 * @param e
	 *            element to be appended to this list
	 * @return {@code true} (as specified by {@link Collection#add})
	 */
	public boolean add(Integer e) {
		linkLast(e);
		return true;
	}

	public Integer get(int index) {
		checkElementIndex(index);
		return node(index).item;
	}

	/**
	 * Tells if the argument is the index of an existing element.
	 */
	private boolean isElementIndex(int index) {
		return index >= 0 && index < size;
	}

	/**
	 * Tells if the argument is the index of a valid position for an iterator or
	 * an add operation.
	 */
	private boolean isPositionIndex(int index) {
		return index >= 0 && index <= size;
	}

	private void checkElementIndex(int index) {
		if (!isElementIndex(index))
			throw new IndexOutOfBoundsException("Out of Bound");
	}

	Node<Integer> node(int index) {
		// assert isElementIndex(index);
int [] output = new int[2];
		if (index < (size >> 1)) {
			Node<Integer> x = first;
			for (int i = 0; i < index; i++)
				x = x.next;
			return x;
		} else {
			Node<Integer> x = last;
			for (int i = size - 1; i > index; i--)
				x = x.prev;
			return x;
		}
	}

	private static class Node<Integer> {
		Integer item;
		Node<Integer> next;
		Node<Integer> prev;

		Node(Node<Integer> prev, Integer element, Node<Integer> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}

}
