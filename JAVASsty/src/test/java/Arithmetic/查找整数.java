package Arithmetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class 查找整数 {
public static void main (String args[])throws Exception{
    BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(sc.readLine());
    String str=sc.readLine();
    String s[]=str.split(" ");
    String s2=sc.readLine();
    int x=Integer.parseInt(s2);
    int a[]=new int[n];
    for(int j=0;j<s.length;j++){
        a[j]=Integer.parseInt(s[j]);
    }
    for(int i=0;i<s.length;i++){
        if(i==s.length-1&&x!=a[s.length-1]){
            System.out.println(-1);
            break;
        }
        if(x==a[i]){
            System.out.println(i+1);
            break;
        }    
    } 
}
}
