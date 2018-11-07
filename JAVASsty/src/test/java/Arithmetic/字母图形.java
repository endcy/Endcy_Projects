package Arithmetic;

import java.util.Scanner;
public class 字母图形 {
    public static void main(String args[]){
    	Scanner scan=new Scanner(System.in);
    	int st[]=new int[2];
    	for(int x=0;x<2;x++)
    		st[x]=scan.nextInt();
        char c[] = new char[st[1]];
        int time = 0;
        int timemax =st[0];
        for(int i=0;i<c.length;i++){
            c[i] = (char) ('B'+i);
        }
        for(int k=0;k<timemax;k++){
            for(int j =0;j<c.length;j++){
                if(j<time){
                    c[j]=(char) (c[j]+1);
                }
                if(j>=time){
                    c[j]=(char) (c[j]-1);
                }               
            }
            time++;
            System.out.print(c);
            System.out.println();
        }
    }
}