// Alice and Bob need to send secret messages to each other and are discussing ways to encode their messages:
// Alice: “Let’s just use a very simple code: We’ll assign ‘A’ the code word 1, ‘B’ will be 2, and so on down to ‘Z’ being assigned 26.”

// Bob: “That’s a stupid code, Alice. Suppose I send you the word ‘BEAN’ encoded as 25114. You could decode that in many different ways!”

// Alice: “Sure you could, but what words would you get? Other than ‘BEAN’, you’d get ‘BEAAD’, ‘YAAD’, ‘YAN’, ‘YKD’ and ‘BEKD’. I think you would be able to figure out the correct decoding. And why would you send me the word ‘BEAN’ anyway?”

// Bob: “OK, maybe that’s a bad example, but I bet you that if you got a string of length 5000 there would be tons of different decodings and with that many you would find at least two different ones that would make sense.”

// Alice: “How many different decodings?”

// Bob: “Jillions!”
// For some reason, Alice is still unconvinced by Bob’s argument, so she requires a program that will determine how many decodings there can be for a given string using her code.
// Input Format:
// First line will contain T (number of test case).
// Each input is consists of a single line containing the message string
// Output Format:
// For each test case print the answer % mod (10^9 +7)
// Constraints:
// 1 <= T <= 100
// 1 <= |S| <= 10^5
// sum of length of all string doesn't exceed 5*10^6
// Sample Input 1:
// 3
// 47974
// 6349988978
// 1001
// Sample Output 1:
// 1
// 1
// 0


import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int num_codes(int input[],int size){
        int output[]=new int[size+1];
        output[0]=1;
        output[1]=1;
        
        for(int i=2;i<=size;i++){
            
            // if(input[i-1]!=0)
                output[i]=output[i-1];
            
            if(input[i-2]!=0 && input[i-1]!=0 && input[i-2]*10+input[i-1]<=26){
                output[i]+=output[i-2];
            
            }
        }
        
        int ans=output[size]%(1000000007);
        return ans;
    }
        
    
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
		int t=s.nextInt();
        
        for(int k=1;k<=t;k++)
        {
            String temp = s.next();
            int[] numbers = new int[temp.length()];
            
            for (int i = 0; i < temp.length(); i++) {
                numbers[i] = temp.charAt(i) - '0';
            }
            
            int flag=0;
            
            for (int i = 1; i < numbers.length; i++) {
                if(numbers[i]==numbers[i-1] && numbers[i]==0){
                    System.out.println(0);
                    flag=1;
                    break;
                }
            }
            
            if(flag!=1)
            System.out.println(num_codes(numbers,numbers.length));

        
        }

}
}
