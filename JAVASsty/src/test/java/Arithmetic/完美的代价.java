package Arithmetic;//http://blog.csdn.net/First_sight/article/details/43053903
import java.util.Scanner;
public class 完美的代价{
private static int change = 0;              // �ı�Ĵ���
private static int old = 0;                 // ��¼����������ַ�
private static char charold = 0;            // ��¼�����ַ�
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int N = Integer.parseInt(sc.nextLine());
	String s = sc.nextLine();
	char str[] = s.toCharArray();
         boolean flag = check(str);             //�Ƿ������ɻ���        
         if (!flag){
        	 System.out.println("Impossible");
         }
	     else{
	        for (int i = 0; i < N/2; i++){
	        if (str[i] != charold) // ���ҿ�ʼ�ҶԳ�
		        {   int j = 0;
		        for (j = N-1-i; j > i; j--)
		        {
		        if (str[i] == str[j]) break; // �ҵ�
		        }
		        change += N-1-i - j;   // �ƶ�����
		        for (int k = j; k < N-1-i; k++)
		        {
		        str[k] = str[k+1];
		        }
		        str[N-1-i] = str[i];    //�ԳƵ�
		        }
	        else           // ����߿�ʼ
		        {
		        int j = 0;
		        for ( j = i; j < N-1-i; j++)
		        {
		        if (str[j] == str[N-1-i]) break; //�ҵ�
		        }
		        change += j-i;   //�ƶ�����
		        for (int k = j; k > i; k--)
		        {
		        str[k] = str[k-1];
		        }
		        str[i] = str[N-1-i];    // �ԳƵ�
		        }
	        }
	        System.out.println(change);
	     }
}


private static boolean check(char[] str)
{
int arr[] = new int[26];
for (int i = 0; i < str.length; i++)
{
arr[str[i]-'a']++;
}

for (int i = 0; i < 26; i++)
{
if (arr[i] % 2 == 1)
{
old++;
charold = (char) (i+'a');
}
}

if (old > 1) return false;
return true;
}
}
