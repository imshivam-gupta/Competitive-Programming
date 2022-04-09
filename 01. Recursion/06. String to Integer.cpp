/*
String to Integer
Send Feedback
Write a recursive function to convert a given string into the number it represents. That is input will be a numeric string that contains only numbers, you need 
to convert the string into corresponding integer and return the answer.

Input format :
Numeric string S (string, Eg. "1234")

Output format :
Corresponding integer N (int, Eg. 1234)

Constraints :
0 <= |S| <= 9
where |S| represents length of string S.

Sample Input 1 :
00001231

Sample Output 1 :
1231

Sample Input 2 :
12567

Sample Output 2 :
12567

*/

#include <bits/stdc++.h>
using namespace std;

int power(int a,int b){
	int c = round(pow(a,b));
    return c;
}


int helper(char input[],int si,int len){
    
    if(input[si]=='\0')
        return 0;
    
    int sa=helper(input,si+1,len);
    int a=input[si]-'0';
    return a*(power(10,len-si-1))+sa; 
}


int stringToNumber(char input[]) {
    int si=0;
    while(input[si]=='0')
    {
        si++;
    }
    
   cout << sizeof(input) << " " << sizeof(input[0]);

    
    return helper(input,si,len);   
}

