package lambda;

import java.util.TreeMap;

interface StringFunc{
	String func(String n);
}

public class Demo {

	public static void main(String[] args) {
		TreeMap<Integer,String> al= new TreeMap<Integer,String>(((o1,o2)->(o1>o2)?1: (o1<o2)? -1 :0));
		al.put(287630,"Apple");
		al.put(234543,"Mango");
		al.put(947543,"Mouse");
		al.put(293423,"Cow");
		al.put(832984,"Zebra");
		al.put(847922,"Tangerine");
		System.out.println("Elements of Tree After sorting: ");
		al.forEach((n,m) -> System.out.println(m));
		System.out.println("\nElements of tree that are even");
		al.forEach((n,m) -> { if (n%2 == 0) System.out.println(m); });
		System.out.println("\nEach value reversed:");
		String outStr;
		for (String val : al.values()) {
			 outStr=reverse((str)->{
				String result="";
				int i;
				for(i=str.length()-1;i>0;i--)
						result+=str.charAt(i);
				
				return result;
			},val);
			System.out.println(outStr);
			
		}
	}

	
	static String reverse(StringFunc sf,String s){
		return sf.func(s);
	}


}
