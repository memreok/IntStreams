package odev9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;


public class MehmetEmreOk_23010310055_Stream {

	public static void main(String[] args) throws IOException {

		System.out.println("multOf10");
		multof10();
		System.out.println();
		
		
		
		int [] array = {5, -1, -3, 20, 47, -10, -8, -4, 0, -6, -6, };
		System.out.println("sum abs vals");
		System.out.println(sumAbsVals(array));
		System.out.println();
		
		System.out.println("count negatives");
		System.out.println(countNegative(array));
		System.out.println();
		
		System.out.println("largest even");
		System.out.println(largestEven(array));
		System.out.println();
		
		System.out.println("pigLatin");
		System.out.println(pigLatin("Bugün hava yağmurlu"));
		System.out.println();
		
		System.out.println("toSortedFrom");
		System.out.println(toSortedFrom("abcadabccab"));
		System.out.println();
		
		System.out.println("longestLine");
		System.out.println(longestLine("poem.txt"));
		System.out.println();
		
		
	}
	
	public static void multof10() {
		int largest = IntStream.of(55, 20, 19, 31, 40, -2, 62, 30)
				.filter(n -> n % 10 == 0)
				.max()
				.getAsInt();
				System.out.println(largest);
	}
	
	public static int sumAbsVals(int [] array) {
		int result = Arrays.stream(array)
				.map(n -> Math.abs(n))
				// .map ( n -> Math::abs )
				.sum();
		return result;
		
	}
	
	public static int countNegative (int [] array) {
		return Arrays.stream(array)
				.filter(n -> n < 0)
				.map(n -> 1)
				// .sum();
				.reduce(0, (n1, n2) -> n1 + n2 );
				
	}
	
	public static int largestEven(int [] array){
		return Arrays.stream(array)
				.filter(n -> n % 2 == 0)
				.max()
				.getAsInt();
	}
	
	public static  String pigLatin (String metin) {
		return Arrays.stream(metin.split(" "))
				.map(s -> s.substring(1) + "-" + s.charAt(0) + "ay")
				.reduce("", (s1, s2) -> s1 + " " + s2);
	}
	
	public static String toSortedFrom(String str) {
		return str.chars()
				.sorted()
				.mapToObj(c -> String.valueOf((char) c))
				.reduce("", (s1, s2) -> s1 + s2);
	}
	
	public static int longestLine(String filename)throws IOException{
		int result = Files.lines(Paths.get(filename))
				.mapToInt(line -> line.length())
				// .mapToInt(String::length)
				.max()
				.getAsInt();
		return result;
	}
	
	
	
	
	
	

}
