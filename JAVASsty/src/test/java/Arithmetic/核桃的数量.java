package Arithmetic;

import java.io.IOException;
import java.util.*;
public class 核桃的数量 {
	public static void main(String args[]) throws IOException{
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		int x=a;
		if(a<30&&b<30&&c<30){
		while(true){
			if(x%a==0&&x%b==0&&x%c==0)
				break;
			else
				x++;
		}
		System.out.print(x);
		}
	}
}
