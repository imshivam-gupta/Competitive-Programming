// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    public static int maximumSumSubarray(int k, ArrayList<Integer> nums,int N){
        
        int i=0;
        int j=0;
        int l=0;
        int max=Integer.MIN_VALUE;
        int sum=0;
        
        while(j<N){
         
            sum+=nums.get(j);
            
            if(j-i+1<k)
                j++;
            
            else if(j-i+1==k){
                if(max<sum){
                    max=sum;
                }
                sum-=nums.get(i);
                j++;
                i++;
                l++;
            }
            
            
            
        }
        
        
        return max;
    }
}
