/*  Matt Coover
    CS 2050
    HW5
*/

import hw5.WordCount;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HW5 {
    
    public static void main(String[] args) throws IOException {

	PrintWriter output = new PrintWriter(new FileWriter("HW5.txt"));
		
        try (
            Scanner scnr = new Scanner (System.in)) {
            System.out.println ("Please enter the file name and location");
                
            String location = scnr.next();
            String cities = new Scanner (new FileReader(location))
                                        .useDelimiter("\\Z").next();
                
            StringBuffer current = new StringBuffer("Filename: ");
   
            cities = cities.replaceAll("[^a-zA-Z0-9'\\s]", "");
            cities = cities.replaceAll("\\s+", " ");
            cities = cities.toLowerCase();
                
            List<WordCount> thatArray = new ArrayList<>();
            LinkedList<WordCount> thisList = new LinkedList<>();
                
            List<String> word = new ArrayList<>				
                                           (Arrays.asList(cities.split(" ")));
            List<String> thisArray = new ArrayList<>();			
                
            thatArray = checkWord(thatArray, word, thisArray);			
                
            output(thatArray, current, output);				
            }
    } // end main

    public static List<WordCount> checkWord (List<WordCount> arr, 
                                    List<String> word, List<String> thisArray) {
	
        thisArray = collectSort(word, thisArray);				
	Iterator<String> itr = thisArray.iterator();			
		
	while (itr.hasNext()) {						
            String move = itr.next();				
            int freq = Collections.frequency(word, move);		
            WordCount x = new WordCount(move, freq);		
            arr.add(x);						
	} // end while
		
	return arr;							
    } // end checkWord

    public static LinkedList<WordCount> checkWordLL (LinkedList<WordCount> list, 
			List<String> word, List<String> thisArray) {
	
        thisArray = collectSort(word, thisArray);							
		
        Iterator<String> itr = thisArray.iterator();						
		
        while (itr.hasNext()) {										
            String move = itr.next();								
            int freq = Collections.frequency(word, move);				
            WordCount x = new WordCount(move, freq);					
            list.add(x);										
        } // end while
        
        return list;												
    } // end checkWordLL

    public static List<String> collectSort (List<String> word, 
                                            List<String> thisArray) {
	Iterator<String> witr = word.iterator();						

	while (witr.hasNext()) {										
            String newWord = (String) witr.next();						
            if (!thisArray.contains(newWord)) {							
                thisArray.add(newWord);								
            } // end if
	} // end while
		
	Collections.sort(thisArray);									
		
	return thisArray;												
    } // end collectSort

    public static void output (List<WordCount> arr, StringBuffer current, 
                                  PrintWriter output) throws IOException {

	Iterator<WordCount> itr = arr.iterator();			
		
	while (itr.hasNext()) {										
            WordCount wc = itr.next();								
            output.println(padString(wc.word, 20, "", " ") + wc.count);		
	} // end while
		
	System.out.println(current);												
    }

    public static String padString(String here, int length, String layo,
                                   String right) { 
        
	String newString = here;
	int a;
	a = length - newString.length();

	for (int i = 0;  i < a;  i++) {
            newString = layo + newString + right;
	} // End for
		
	return newString;
    } // end padString
	
} // end HW5