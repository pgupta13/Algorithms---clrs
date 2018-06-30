

import java.io.IOException;
import java.util.Scanner;

public class Huffman {
/* Note: This java class uses MinHeap.java as priority queues. This java class was created by me as an assignment of INFS 519 lecture.*/
	public static final int RADIX = 256;

	public static int huffman(int[] frequencyOfChars, int len) {

		Node node = makeTree(frequencyOfChars);

		String[] st = new String[RADIX];
		makeCodeWords(st, node, "");
		for (int i = 0; i < st.length; i++) {
			if (st[i] != null) {
				System.out.println("Codeword for " + Character.toString((char) i) + " is: ");
				System.out.println(st[i]);
			}
		}

		return 0;

	}

	public static void makeCodeWords(String[] table, Node x, String code) {

		if (x.isLeaf()) {
			table[x.symbol] = code;

		} else if (!x.isLeaf()) {
			makeCodeWords(table, x.left, code + '2');
			
			makeCodeWords(table, x.mid, code + '1');
			makeCodeWords(table, x.right, code + '0');
		}
	}

	public static Node makeTree(int[] freq) {
	
		MinHeap<Node> pqelement = new MinHeap<>(RADIX);
		for (char i = 0; i < freq.length; i++)
			if (freq[i] > 0)
				pqelement.insert(new Node(i, freq[i]));

		// when one character with a nonzero frequency
		if (pqelement.size() == 1) {
			if (freq['\0'] == 0) {
				pqelement.insert(new Node('\0', 0));
				pqelement.insert(new Node(' ', 0));
			}

			else {
				pqelement.insert(new Node('1', 0));
				pqelement.insert(new Node('1', 0));
			}
		} else if (pqelement.size() == 2)
			pqelement.insert(new Node(' ', 0));
		
		if(pqelement.size()%2==0)
			pqelement.insert(new Node('*', 0));
			
		// merging two smallest weighting trees
		while (pqelement.size() > 1) {
			Node left = pqelement.delMin();
		
			Node middle = pqelement.delMin();
			Node right = pqelement.delMin();
			Node parent = new Node('\0', left,middle, right, left.freq + right.freq + middle.freq);
			pqelement.insert(parent);
		}
		return pqelement.delMin();

	}

	private static class Node implements Comparable<Node> {
		private Node left;
		private Node right;
		private Node mid;
		private char symbol;
		private int freq;

		public Node(char c, int freq) {
			this(c, null, null, null, freq);
		}

		public Node(char symbol, Node left, Node mid, Node right, int freq) {
			this.symbol = symbol;
			this.left = left;
			this.right = right;
			this.mid = mid;
			this.freq = freq;
		}

		public Node getLeft() {
			return this.left;
		}

		public Node getRight() {
			return this.right;
		}

		public Node getMid() {
			return this.mid;
		}

		public char getSymbol() {
			return this.symbol;
		}

		public int getFreq() {
			return this.freq;
		}

		public boolean isLeaf() {
			return this.left == null && this.right == null && this.mid == null;
		}

		public int compareTo(Node other) {
			return this.freq - other.freq;
		}

		@Override
		public String toString() {
			return "(" + this.symbol + " " + freq + ")";
		}
	}

	public static void main(String[] args) throws IOException {
		Huffman obj = new Huffman();

		System.out.println("Enter length of alphabet");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] freqArray = new int[RADIX];
		System.out.println("Enter frequency of each char of alphabet, for a, b, c and so on..till z");
		for (int i = 97; i < 97 + n; i++) {
			System.out.println("Enter frequency of " + Character.toString((char) i));
			freqArray[i] = in.nextInt();
		}
		obj.huffman(freqArray, n);
	}
}
