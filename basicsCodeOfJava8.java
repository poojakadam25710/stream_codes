/**
 * 
 */
package java8Features;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 */
public class basicsCodeOfJava8 {
	public static void main(String[] args) {
		
	
	//======= first non repeating character========
	String s1="anagha";
	
	char ch=s1.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new ,Collectors.counting()))
			.entrySet().stream().filter(n->n.getValue()==1).map(Map.Entry::getKey).findFirst().get();
	
	System.out.println(ch);
	
	//======= first non repeating word========
	String s2="India is my country and it is very nice";
	
	String word=Arrays.stream(s2.toLowerCase().split("\\s+")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new ,Collectors.counting()))
			.entrySet().stream().filter(n->n.getValue()==1).map(Map.Entry::getKey).findFirst().get();
	System.out.println(word);
	
	//=======freq of each character========
	String s3="Infiormation";
	
	Map<Character, Long> map= s3.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));	
	System.out.println(map);
	
	//=======freq of each word========
	String s4="India is my country and it is very nice country my india";
	
	Map<String, Long> map1=Arrays.stream(s4.toLowerCase().split("\\s+")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
	System.out.println(map1);
	
	//===============Reverse each word in a sentence=======================
	
	String s7="java is easy";
	
	String reverseWord=Arrays.stream(s7.toLowerCase().split("\\s+")).collect(Collectors.collectingAndThen(Collectors.toList(), list->{
		Collections.reverse(list);
		return String.join(" ", list);	
	}
	));
	System.out.println(reverseWord);
	
	
	
	//===================Find vowels count in a String======================
	
	String s5="indiao";
	
	Map<Character, Long> volwel=s5.toLowerCase().chars().mapToObj(c->(char)c).filter(n->"aeiou".indexOf(n)!=-1)
	.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	System.out.println(volwel);
	
	
	//===================Find consonants count in a String======================
	
		String s6="indiao";
		
		Map<Character, Long> Consonant=s5.toLowerCase().chars().mapToObj(c->(char)c).filter(n->"aeiou".indexOf(n)==-1)
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(Consonant);
		
		
	//===================Palindrome======================
	String s8="Kadak";
	
	boolean palindrome=s8.equalsIgnoreCase(new StringBuilder(s8).reverse().toString());
	
	System.out.println(palindrome);
	
	
	//=========================Find longest word in a sentence======================
	
	String s9="India is my country";
	
	String longestWord=Arrays.stream(s9.toLowerCase().split("\\s+")).reduce((w1,w2)->w1.length()>=w2.length()?w1:w2).orElse("");
	System.out.println(longestWord);
	
	//=========================Find shortest word in a sentence======================
	
		String s10="India mh is my country";
		
		String shortest=Arrays.stream(s10.toLowerCase().split("\\s+")).reduce((w1,w2)->w1.length()<=w2.length()?w1:w2).orElse("");
		System.out.println(shortest);
		
	//============================Find shortest word if more than one words are there============== 
		String s11 = "India mh is my country";

		int minLength = Arrays.stream(s11.split("\\s+"))
		        .mapToInt(String::length)
		        .min()
		        .orElse(0);

		String secondShortest = Arrays.stream(s11.split("\\s+"))
		        .filter(w -> w.length() == minLength)
		        .skip(1)                 // 🔥 skip first shortest
		        .findFirst()
		        .orElse("");

		System.out.println(secondShortest);
		
		
	//=====================Remove duplicate characters======================
		String s12="poojaa";
		
		List<Character> ch4=s12.toLowerCase().chars().mapToObj(c->(char)c).distinct().toList();
		System.out.println(ch4);
		
		List<Character> ch6=s12.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream().filter(n->n.getValue()==1).map(Map.Entry::getKey).toList();
		System.out.println(ch6);
		
  //========================find duplicate elements=============================
		
		String s13="Anaggha";
		List<Character> ch5=s13.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream().filter(n->n.getValue()>=2).map(Map.Entry::getKey).toList();
		System.out.println(ch5);
		
		
//==========================Find common characters between two Strings===================	
		
		String s14="pooja";
		String s15="anaghao";
		
		List<Character> common = s14.toLowerCase()
		        .chars()
		        .mapToObj(c -> (char) c)
		        .filter(c -> s15.toLowerCase().indexOf(c) != -1).distinct().
		        collect(Collectors.toList());

		System.out.println(common);
		
		
//===========================Find Unique characters between two Strings==========================
		
		String s16="infop";
		String s17="information";
		
		List<Character> unique=Stream.concat(s16.toLowerCase().chars().mapToObj(c->(char)c), s17.toLowerCase().chars().mapToObj(c->(char)c))
				.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(n->n.getValue()==1)
				.map(Map.Entry::getKey).toList();
		
		System.out.println(unique);
		
		
		
		
		
		
		
		
		
				

		
	
	
	

	
	
	
	
	
	
	
	
	
	
		
	}
}
