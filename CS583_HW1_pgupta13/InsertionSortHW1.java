

import java.util.Random;
import java.util.Scanner;

public class InsertionSortHW1 {
	public static int COUNTER=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.println("Enter size of input array ");
		int x = in.nextInt();
		
		//System.out.println("Enter input array elements, keeping space in between two elements: ");
		int[] a = new int[x];
		Random rand = new Random(); 
		 
		//System.out.println("Enter the input : ");
		for(int i=0;i<x;i++){
			
			a[i]= rand.nextInt(x) +1; 
		}
		
		InsertionSortHW1 obj = new InsertionSortHW1();
		obj.insertionsort(a);
		for (int i = 0; i < x; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\nCounter is : "+ COUNTER);
	}

	public int[] insertionsort(int[] inputarr) {
		int len = inputarr.length;
		
		// for assignment, i=0 and comparision 
		COUNTER= COUNTER +3;
		for (int i = 1; i < len; i++) {
			//for comparison and increment
			COUNTER = COUNTER +2;
			int pos = insertByBinarySearch(inputarr,inputarr[i],0, i);
			// ASSIGNMENT
			COUNTER++;
			// for  i=0 and comparision 
			COUNTER= COUNTER +2;
			for(int j=i;j>pos;j--){
				//for comparison and increment
				COUNTER = COUNTER +2;
				//for comparison and arithmatic operation
				
				COUNTER = COUNTER +2;
				if(inputarr[j]>inputarr[j-1]){
					COUNTER++;
					break;
				}
				
				int temp = inputarr[j-1];
				inputarr[j - 1] = inputarr[j];
				inputarr[j] = temp;
				COUNTER= COUNTER+5;
			}
			}
		COUNTER++;
		return inputarr;
		}
	
	int insertByBinarySearch(int[] a, int add, int low, int high){ int lo = low;
    int hi = high;
    int pos =0;
    //2 assignment and 1 comparison statment
    COUNTER=COUNTER+3;
    while (lo <hi) {
        // for 1 assignment , 1 arithmatic and 2 comparison statement
    	COUNTER= COUNTER+4;
        int mid =  (hi + lo) / 2;
        if      (add < a[mid]) {hi = mid;
        COUNTER++;}
        else if (add > a[mid]) {lo = mid + 1;
        COUNTER=COUNTER+2;}
        else{ 
        	COUNTER=COUNTER+2;
        	return pos =mid;}
    }
    COUNTER++;
    return pos;}
	
}
