

import java.util.Scanner;

public class RodCut {
	static double [] s ;
	public static void main(String[] args){
		
		int[] nums = {0,1,5,8,9,10,17,17,20,24,30};
		System.out.println("Enter the lenth req");
		Scanner n = new Scanner(System.in);
		int len = n.nextInt();
		System.out.println("Enter the cost of cut incurred : ");
		int costPerCut = n.nextInt();
		s= new double[nums.length+1];
		System.out.println("Optimal Value : "+maxValue(nums,len,costPerCut));
		
		
	}
	public static int maxValue(int[] nums, int n,int cost){
		int[] maxValueTable = new int[nums.length+1];
		maxValueTable[1] = nums[1];
		int max = Integer.MIN_VALUE;
		for(int i=2;i<nums.length;i++){
			max = nums[i];
			for(int k = i-1;k>=1;k--){
				if(max<(maxValueTable[i-k]+nums[k]-cost)){
					max=maxValueTable[i-k]+nums[k];
					//s[i]=k;
				}
				//max = Math.max(max, maxValueTable[i-k]+nums[k]);
			}
			maxValueTable[i]= max;
		}
		
		return maxValueTable[n];
		
	}
	

}
