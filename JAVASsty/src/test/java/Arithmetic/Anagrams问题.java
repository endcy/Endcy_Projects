package Arithmetic;

import java.io.IOException;
import java.util.*;
public class Anagrams问题 {
	public static void main(String[] args) throws IOException{
		Scanner scan=new Scanner(System.in);
		String a=scan.nextLine();
		String b=scan.nextLine();
		if(a.length()==b.length()){
		int len=a.length();
		int arra[]=new int[len];
		int arrb[]=new int[len];
		char arraa[]=new char[len];
		char arrbb[]=new char[len];
		int c=0;
		a=a.toUpperCase();
		b=b.toUpperCase();
		arraa=a.toCharArray();
		arrbb=b.toCharArray();
		for(int i=0;i<len;i++){
			arra[i]=(int)arraa[i];
			arrb[i]=(int)arrbb[i];		
		}
		Arrays.sort(arra);
		Arrays.sort(arrb);
		for(int i=0;i<len;i++){
			if(arra[i]==arrb[i])
				c++;
			else{
				System.out.print("N");
				break;
			}		
		}
		if(c==arra.length)
			System.out.print("Y");
		}
		else
			System.out.print("N");
	}

}
