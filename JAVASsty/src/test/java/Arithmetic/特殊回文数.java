package Arithmetic;/*
import java.util.Scanner;;
public class ��������� {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		for(int i=10;i<100;i++) {
			for(int j=0;j<10;j++) {
				for(int k=0;k<100;k++) {
					if((i/10+i%10)*2+j==a&&i/10==k%10&&i%10==k/10) {
						System.out.println(i*1000+j*100+k);
					}
				}
			}
			
		}
		for(int i=100;i<1000;i++) {
			for(int j=100;j<1000;j++) {
				int l=j/100+j%10*100+j%100-j%10;
				if((i/100+i%10+(i%100)/10)*2==a&&l==i)
					System.out.println(i*1000+j);
			}
		}
	}
}
*///�˷������һ����������󣬵����������ȷ��//
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class 特殊回文数 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        ArrayList<Integer> rs= new ArrayList<Integer>();    
        for(int i=1; i<10; i++)
            for(int j=0; j<10; j++)
                for(int k=0; k<10; k++){
                    if(2*i+2*j+k==n)
                        rs.add(i*10000 + j*1000 + k*100+ j*10 + i);
                    if(2*i+2*j+2*k==n)
                        rs.add(i*100000 + j*10000+ k*1000 + k*100+ j*10 + i);
                }
        Collections.sort(rs);
        for(int i=0; i< rs.size(); i++)
            System.out.println(rs.get(i));
    }
}
