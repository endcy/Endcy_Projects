package Arithmetic;
/*
import java.io.IOException;
import java.util.*;
public class Arithmetic.出现次数最多的整数{
	public static void main(String[] args) throws IOException,ArrayIndexOutOfBoundsException{
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		int arr[]=new int[num];
		int count[]=new int[num];
		for(int i=0;i<num;i++){
			count[i]=0;
			arr[i]=scan.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0;i<num-1;i++){
			count[i]=Countsame(arr,i);
			i=i+count[i]-1;
		}
		int temp=0,mark=0;
		for(int i=0;i<num;i++){
			if(temp<count[i]){
				temp=count[i];
				mark=i;
				}
	
		}
		System.out.print(arr[mark]);
	}

	private static int Countsame(int arr[], int i2) {
		int c=1;
		while(arr[i2]==arr[i2+1]){
			i2++;
			c++;
		}
		return c;
	}
}
*/
import java.io.*;

public class 出现次数最多的整数 {	
	public static void main(String[] args) {
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in),1);		
				String line=br.readLine();
				int n=Integer.parseInt(line);
				if(n>0){
				int[][] num=new int[2][n];
				int max=1,maxn=0;
				for(int i=0;i<n;i++){
					line=br.readLine();
					num[0][i]=Integer.parseInt(line);
					int g=1;
					for(int j=i-1;j>=0;j--)
						if(num[0][j]==num[0][i]){
							g=num[1][j]+1;
							break;
						}
					num[1][i]=g;
					if(g>max){
						max=g;
						maxn=i;
					}
				}
				System.out.println(num[0][maxn]);
				}else System.out.println("");
		}catch(Exception e){
			System.out.println("Message:"+e.getMessage());
		}
	}
	
}