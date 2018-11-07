package Arithmetic;

//SrtingBuffer������е�append����Ԥ�ı����
public class 五位01字串 {
	public static void main(String args[]) {
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				for(int k=0;k<2;k++) {
					for(int l=0;l<2;l++) {
						for(int m=0;m<2;m++) {
							StringBuffer a=new StringBuffer();
							StringBuffer s1=a.append(i).append(j).append(k).append(l).append(m);
							System.out.println(s1);
						}
					}
				}
			}
		}
		
	}
}
