package Arithmetic;

import java.util.*;
public class 分解质因素{
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt(), b=scan.nextInt();
		int zj[]=new int[b];
		for(int i=0;i<b;i++)
			zj[i]=0;
		
		if(a>=2&&b<=10000&&a<=b){
			zj[0]=2;int v=1;
				for(int x=3;x<=b;x++){	//�洢��������
				for(int i=2;i<x;i++){				
					if(i==x-1){
						zj[v]=x;
						v++;
						}
					if(x%i==0){
						break;
						}
					}
				}
/*				for(int x=0;x<b;x++)
				System.out.print(zj[x]);
				System.out.println();
*/		
			for(int j=a;j<=b;j++){
				int z=0,y=1,s=j,i=0;
				int temp[]=new int[b];
				for(int u=0;u<b;u++)
					temp[u]=0;			
				while(zj[i]!=0&&zj[i]<=j){				
					if(s%zj[i]==0){
						s=s/zj[i];
						temp[z]=zj[i];
						//System.out.print(z+"="+zj[i]+" ");//�жϲ���					
						y*=zj[i];z++;					
					}
					else
						{i++;
						//System.out.println("xx");
						}
					if(y==j){
						int m=0;
						System.out.print(j+"="+temp[m]);
						m++;
						while(temp[m]!=0){
							System.out.print("*"+temp[m]);
							m++;
						}
						System.out.println();
						break;
					}
				}
			}		
		}
	}
}
