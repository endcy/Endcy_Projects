package Arithmetic;

import java.util.Scanner;
public class 矩阵乘法{
	public static void main(String[] args) {
		int N,M;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//����
		M = sc.nextInt();//����
		int[][] matrix = new int[N][N];
		//����
		for(int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			 {
				matrix[i][j]=sc.nextInt();
			}
		}
		//�жϼ�����
		if(M==1)
		{
			printNum(matrix,N);
		}
		else if(M==0)
		{
			for (int i=0;i < N;i++ )
			{
				for (int j=0; j<N ;j++ )
				{
					matrix[i][j]=1;
				}
			}
			printNum(matrix,N);
		}
		else if(M>=2&&M<=5)
		{
			getNum(matrix,N,M);
		}
	}

	public static void getNum(int[][] matrix,int N,int M)
	{
		int[][] matrixCopy = new int [N][N];
		
		for(int i = 0 ;i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				for (int k = 0; k < N; k++)
				 {
					matrixCopy[i][j]+=matrix[i][k]*matrix[k][j];//����
				}
			}
		}
		--M;
		while((--M)>0)
		{	
			int [][] temp = new int[N][N];
			for(int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				 {
					temp[i][j]=matrixCopy[i][j];//���ڱ����ϴν��
				}
			}

			for(int i = 0 ;i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					matrixCopy[i][j]=0;//��������ϴν����temp�����ϴν��μ�����
					for (int k = 0; k < N; k++)
					 {
						matrixCopy[i][j]+=temp[i][k]*matrix[k][j];
					}
				}
			}
		}
		printNum(matrixCopy,N);	
	}

	public static void printNum(int[][] matrix,int N)
	{
		for(int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			 {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
}