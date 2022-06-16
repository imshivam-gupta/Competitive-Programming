//                        Min. Absolute Difference In Array

// Given an integer array A of size N, find and return the minimum absolute difference between any two elements in the array.
// We define the absolute difference between two elements ai and aj (where i != j ) as |ai - aj|.
// Input format :
// The first line of input contains an integer that denotes the number of test cases. Let us denote it by the symbol T. 
// Each of the test cases contain two lines. The first line of each test case contains an integer, that denotes the value of N. The following line contains N space separated integers, that denote the array elements.
// Constraints :
// 1 <= T <= 10
// 2 <= N <= 10^5
// 0 <= arr[i] <= 10^8
// Output Format :
// You have to print minimum difference for each test case in new line.
// Sample Input 1:
// 1
// 5
// 2 9 0 4 5
// Sample Output 1:
// 1





import java.util.*;

public class Solution {
    
	public static void main(String[] args) {
        
        Scanner s=new Scanner(System.in);
        int testcases=s.nextInt();
        
        while((testcases--)>0){
            
            int n=s.nextInt();
            int arr[]=new int[n];
            
            for(int i=0;i<n;i++){
                arr[i]=s.nextInt();
            }
            
            Arrays.sort(arr);
            
            // for(int i : arr)
                // System.out.println(i);
            
            int min=Integer.MAX_VALUE;
            
            for(int i=1;i<n;i++){
                if(arr[i]-arr[i-1]<min){
                    min=arr[i]-arr[i-1];;
                }
            }
            
            System.out.println(min);
        }
		
	}

}
