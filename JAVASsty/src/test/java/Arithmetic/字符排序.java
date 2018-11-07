package Arithmetic;

import  java.util.*;
/*public class Arithmetic.字符排序 {
	public static long count=0;
	private void FPermutation(Vector<Character>sourse,Vector<Character>result,int x){
		for(int i=0;i<sourse.size();i++){
			Vector<Character>tsourse=new Vector<Character>(sourse);
			Vector<Character>tresult=new Vector<Character>(result);
			tresult.add(sourse.elementAt(i));
			tsourse.remove(i);
			new Arithmetic.字符排序().FPermutation(tsourse, tresult,x);
		}
		if(result.size()!=0){
			for(int i=0;i<result.size();i++){
				if(result.elementAt(i).toString().length()!=x)
				System.out.print(result.elementAt(i));
			}
			System.out.println();
			count++;
			return;
		}
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		Vector<Character>sourse=new Vector<Character>();
		Vector<Character>result=new Vector<Character>();
		for(int i=0;i<n;i++){
			sourse.add((char)('A'+i));
		}
		new 	Arithmetic.字符排序().FPermutation(sourse, result,n);
		System.out.println(Arithmetic.字符排序.count);
	}
}
*/
public class 字符排序 {
	public static void RemoveAg(String s,Set<Character>lis){
		for(char x:s.toCharArray()){
			lis.add(x);
		}
	}
	public static void convert(List<Character>lis,Set<Character>sets){
		Iterator<Character>iter=sets.iterator();
		while(iter.hasNext()){
			lis.add(iter.next());
		}
	}
	public static void check(Set<Character>sets){
		List<Character>lis=new ArrayList<Character>();
		convert(lis,sets);
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<lis.size()-2;i++){
			for(int j=i+1;j+1<lis.size();j++){
				for(int k=j+1;k<lis.size();k++){
					sb.append(lis.get(i));
					sb.append(lis.get(j));
					sb.append(lis.get(k));
					System.out.println(sb);
					sb.setLength(0);
				}
			}
		}
	}
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		String s=scan.nextLine();
		Set<Character>sets=new LinkedHashSet<Character>();
		RemoveAg(s,sets);
		check(sets);
	}
	
	
}