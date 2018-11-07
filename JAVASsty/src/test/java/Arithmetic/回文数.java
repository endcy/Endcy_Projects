package Arithmetic;

import java.util.Scanner;
public class 回文数 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        for(int i=1001;i<10000;i++)
        {
            int j=0;
            for(int x=i;x!=0;x/=10)
            {
                j=j*10+x%10;
            }
            if(j==i)System.out.println(i);
        }
    }
}