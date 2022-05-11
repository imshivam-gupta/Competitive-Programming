/*   Question

Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x, is the first greater element on right side of x in the array. Elements for which no greater element exist, consider next greater element as -1.
Input format :

Line 1 : Size of input array

Line 2 : Array elements (separated by space)

Constraints:
Time Limit: 1 second
Size of input array lies in the range: [1, 1000000]
Sample Input

5
3  8  1  2  0

Sample Output
8 -1  2 -1 -1

*/

import java.util.ArrayList;
import java.util.Stack;
import java.util.*;


public class solution {    
    
	public static ArrayList<Integer> nextGreaterElement(ArrayList<Integer> input) {
		int s=input.size();
        int c=0;
        
        ArrayList<Integer> ans=new ArrayList<Integer>();
       

        Stack<Integer> stack = new Stack<Integer>();
        
        
        for(int i=s-1;i>=0;i--){    
            
            if(stack.isEmpty()){
                ans.add(-1);
                // System.out.println(ans.size());
            }
            
            else{
                
                while(!stack.isEmpty()){
                    
                    if(stack.peek()>input.get(i)){
                        ans.add(stack.peek());
                        // System.out.println(ans.size());
                        break;
                    }
                    
                    else{
                        stack.pop();
                    }
                    
                }
                
//                 while(!stack.isEmpty()){
//                     c=stack.pop();
                    
//                     if(c>input.get(i)){
//                         ans.add(i,c);
//                         break;
//                     }
//                 }
                
                // && ans.get(i)==null
                 if(stack.isEmpty() ){
                     ans.add(-1);
                 }
                
            }
            
            int a=input.get(i);
                stack.push(a); 
            
        }
        
        Collections.reverse(ans);
        
        int sum = ans.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        return ans;
        
        
	}
}


// MAIN CODE

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);
	
	public static ArrayList<Integer> takeInput(){
		int size = s.nextInt();
		ArrayList<Integer> input = new ArrayList<Integer>();
		for(int i = 0; i < size; i++){
			input.add(s.nextInt());
		}
		return input;
	}

	public static void main(String[] args) {
		ArrayList<Integer> input = takeInput();
		ArrayList<Integer> output = solution.nextGreaterElement(input);
		for(int i : output) {
			System.out.print(i + " ");
		}
	}
}
