

import java.util.*;




public class MergeSortHW1 {
	public static int COUNTER=0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter input size:");
		int x = in.nextInt();
		Integer[] a = new Integer[x];
		Random rand = new Random(); 
		 
		//System.out.println("Enter the input : ");
		for(int i=0;i<x;i++){
			
			a[i]= rand.nextInt(x) +1; 
		}
		
		
		mergeSort(a,  0, a.length - 1);
		System.out.println(Arrays.toString(a));
		System.out.println(COUNTER);
	}
	

	
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

	
	void linkLast(Integer e) {
		final Node<Integer> l = last;
		final Node<Integer> newNode = new Node<>(l, e, null);
		last = newNode;
		// 2 assignment statment and 1 equality check statement
		COUNTER = COUNTER +3;
		if (l == null){
			first = newNode;
			COUNTER ++;
		}
		else{
			l.next = newNode;
			COUNTER ++;}
		size++;
		modCount++;
		COUNTER = COUNTER +2;
	}

	public int size() {
		COUNTER ++;
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
		COUNTER ++;
		return true;
	}

	public Integer get(int index) {
		checkElementIndex(index);
		COUNTER++;
		return node(index).item;
	}

	/**
	 * Tells if the argument is the index of an existing element.
	 */
	private boolean isElementIndex(int index) {
		// 2 check operators
		COUNTER = COUNTER +2;
		return index >= 0 && index < size;
	}

	/**
	 * Tells if the argument is the index of a valid position for an iterator or
	 * an add operation.
	 */
	private boolean isPositionIndex(int index) {
		// 2 check operators
		COUNTER = COUNTER +2;
		return index >= 0 && index <= size;
	}

	private void checkElementIndex(int index) {
		COUNTER ++;
		if (!isElementIndex(index)){
			COUNTER ++;
			throw new IndexOutOfBoundsException("Out of Bound");}
	}

	Node<Integer> node(int index) {
		// assert isElementIndex(index);
int [] output = new int[2];
//1 assignment statment and 2 value check statement in if statment
COUNTER =COUNTER +3;
		if (index < (size >> 1)) {
			Node<Integer> x = first;
			COUNTER ++;
			// for i=0;
			COUNTER++;
			//for comparison 
			COUNTER++;
			
			for (int i = 0; i < index; i++){
				//for comparision and increment
				COUNTER= COUNTER +2;
				// assignment
				COUNTER ++;
				x = x.next;}
			COUNTER ++; // for return statement
			return x;
		} else {
			COUNTER ++;
			Node<Integer> x = last;
			// for i=0;
						COUNTER++;
						//for comparision 
						COUNTER++;
			for (int i = size - 1; i > index; i--){
				//for comparision and increment
				COUNTER= COUNTER +2;
				COUNTER ++;
				x = x.prev;}
			COUNTER ++;
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
			COUNTER = COUNTER +3;
		}
	}

	

	private static void mergeSort(Integer[] a, int left, int right) {
		if (left < right) {
			//comparison
			COUNTER++;
			int center = (left + right) / 2;
			//arithmatic and assignment
			COUNTER= COUNTER + 2;
			mergeSort(a, left, center);
			mergeSort(a, center+1, right);
			//arithmatic
			COUNTER++;
			merge(a, left, center + 1, right);
			
			//arithmatic
			COUNTER++;
		}
	}

	private static void merge(Integer[] a, int p, int q, int r) {
		int leftsize = q - p + 2;
		//2 arithmatic statments and 1 assignment statement
		COUNTER = COUNTER +3;
		int rightsize = r - q + 2;
		//2 arithmatic statments and 1 assignment statement
		COUNTER = COUNTER +3;
		
		LinkedList left =new LinkedList();
		// object create
		COUNTER++;
		LinkedList right =new LinkedList(); 
		// object create
		COUNTER++;

		// for i=0;
		COUNTER++;
		//for comparision 
		COUNTER++;
		for (int i = 0; i < leftsize - 1; i++) {
			//for comparision and increment
			COUNTER= COUNTER +2;
			left.add(  a[p + i]);
			//2 operations : arithmatic and assignment statement
			COUNTER = COUNTER+2;

		}
		
		// for i=0;
				COUNTER++;
				//for comparision 
				COUNTER++;
		for (int i = 0; i < rightsize - 1; i++) {
			//for comparision and increment
			COUNTER= COUNTER +2;
 			right.add(  a[q + i]);
 		//2 operations : arithmatic and assignment statement
			COUNTER= COUNTER +2;

		}
		
		left.add(Integer.MAX_VALUE);
		
		right.add(Integer.MAX_VALUE);
		COUNTER = COUNTER +2;
		int leftpos = 0, rightpos = 0;
		COUNTER = COUNTER +2;
		
		// for i=0;
		COUNTER++;
		//for comparision 
		COUNTER++;
		for(int i=p; i<=r; i++){
			//for comparision and increment
			COUNTER= COUNTER +2;
			
			if(left.get(leftpos)<right.get(rightpos))
			{
				// 3 steps : 2 get operations and 1 comparision
				COUNTER = COUNTER +3;
				a[i]=left.get(leftpos++);
				// 3 operations : 1 get operation, 1 post increment statement and one assignment statement
				COUNTER = COUNTER + 3;
		}
			else{
				a[i]= right.get(rightpos++);
				// 3 operations : 1 get operation, 1 post increment statement and one assignment statement
				COUNTER = COUNTER + 3;	
			}
			}

	}
	
	
	 
	
	}