package Arithmetic;

import java.util.Scanner;

public class 数的读法
{
public static String nums1[] = {"ling", "yi", "er", "san", "si", "wu","liu","qi","ba","jiu","shi"};
public static String nums2[] = {"shi","bai","qian","wan","yi"};
// 20 0000 0000 , 21 0000 0000, 20 0010 0001
public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
String str = sc.nextLine();
sc.close();      
while(str.length() < 10)
{
str = "n"+str;
}

String re = fun(str);
System.out.println(check(re));
}

// 12 3456 7009
private static String fun(String str)
{
String re = "";
int ch;

// 1     12 3456 7009
if (str.charAt(0) != 'n')
{
ch = str.charAt(0) - '0';
re += nums1[ch] + " " + nums2[0]+" ";
}
    // 2     12 3456 7009
if (str.charAt(1) != 'n')
{
ch = str.charAt(1) - '0';
if (ch == 0) re += nums2[4] + " ";
else
re += nums1[ch] + " "+nums2[4]+" ";
}
    // 3     12 3456 7009
if (str.charAt(2) != 'n')
{
ch = str.charAt(2) - '0';
if (ch == 0) re += nums1[ch] +" ";
else
re += nums1[ch] + " "+nums2[2]+" ";
}
    // 4     12 3456 7009
if (str.charAt(3) != 'n')
{
ch = str.charAt(3) - '0';
if (ch == 0) re += nums1[ch] +" ";
else
re += nums1[ch] + " "+nums2[1]+" ";
}
    // 5     12 3456 7009
if (str.charAt(4) != 'n')
{
ch = str.charAt(4) - '0';
if (ch == 0) re += nums1[ch] +" ";
else
re += nums1[ch] + " "+nums2[0]+" ";
}
    // 6     12 3456 7009
if (str.charAt(5) != 'n')
{
ch = str.charAt(5) - '0';
if (ch == 0) re += nums2[3] +" ";
else
re += nums1[ch] + " "+nums2[3]+" ";
}
    // 7     12 3456 7009
if (str.charAt(6) != 'n')
{
ch = str.charAt(6) - '0';
if (ch == 0) re += nums1[ch] +" ";
else
re += nums1[ch] + " "+nums2[2]+" ";
}
    // 8     12 3456 7009
if (str.charAt(7) != 'n')
{
ch = str.charAt(7) - '0';
if (ch == 0) re += nums1[ch] +" ";
else
re += nums1[ch] + " "+nums2[1]+" ";
}
    // 9     12 3456 7009
if (str.charAt(8) != 'n')
{
ch = str.charAt(8) - '0';
if (ch == 0) re += nums1[ch] +" ";
else
re += nums1[ch] + " "+nums2[0]+" ";
}
    // 10     12 3456 7009
if (str.charAt(9) != 'n')
{
ch = str.charAt(9)-'0';
re += nums1[ch];
}
return re;
}

public static String check(String re)
{
// ����ĩβ 'ling'
    while (re.trim().endsWith("ling"))
    {
    re = re.substring(0, re.trim().length()-4);
    }
    // ���������'ling'
    while (re.trim().indexOf("ling ling")!=-1)
    {
    re = re.replaceAll("ling ling", "ling");
    }
    // ����'ling wan'
    if (re.trim().indexOf("ling wan")!=-1)
    {
    re = re.replaceAll("ling wan", "wan");
    }
    // ���� 'yi shi er wan' ȥ�� 'yi'
    if (re.trim().startsWith("yi shi"))
    {
    re = re.substring(3, re.length());
    }
    return re;
}
}