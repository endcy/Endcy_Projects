package Arithmetic;//import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
public class 圆的面积 {
public static void main(String[] args) {
	double PI=3.14159265358979323;
	double s;
	Scanner ss=new Scanner(System.in);
	int r=ss.nextInt();
	s=r*r*PI;
	BigDecimal d=new BigDecimal(r*r); 
	BigDecimal x=new BigDecimal(PI);
	BigDecimal i=d.multiply(x).setScale(7,RoundingMode.HALF_EVEN);
	System.out.print(i);
}
}
