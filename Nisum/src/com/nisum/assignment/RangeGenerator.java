package com.nisum.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * This class reads input ranges from user through console and prints output ranges on console.
 * 
 * @author Admin
 *
 */
public class RangeGenerator {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Input Ranges : ");
		String input = reader.readLine();
		processInput(input);
	}
	
	public static void processInput(String input) {

		StringTokenizer inputStringTokenizer = new StringTokenizer(input," ");
		ArrayList<RangeElement> listOfRangeElements = new ArrayList<RangeElement>();
		
		while(inputStringTokenizer.hasMoreTokens()) {
			String inputStr = inputStringTokenizer.nextToken();
			String[] splitStr = inputStr.split(",");
			String lowerBound = splitStr[0].substring(1);
			int len = splitStr[1].length();
			String upperBound = splitStr[1].substring(0, len - 1);
		
			RangeElement rangeElement = new RangeElement(Integer.parseInt(lowerBound),Integer.parseInt(upperBound));
			listOfRangeElements.add(rangeElement);
		}
		
		//remove duplicate objects
		HashSet<RangeElement> rangeElementSet = new HashSet(listOfRangeElements); 
		
		ArrayList<RangeElement> listWithoutDuplicates = new ArrayList(rangeElementSet);
		//sort objects based on lowerBound
		Collections.sort(listWithoutDuplicates, new RangeElementComparator());
		
			int i=0;
			int j=0;
			
			int lowerB = -1;
			int upperB = -1;
			StringBuilder strDisplay = new StringBuilder();
			for (i=0; i < listWithoutDuplicates.size(); i++) {
				
				RangeElement rangeElement = listWithoutDuplicates.get(i);
				Integer lb0 = rangeElement.getLowerBound();
				Integer ub0 = rangeElement.getUpperBound();
				
				for(j = i; j < listWithoutDuplicates.size(); j++) {
					RangeElement rangeElem = listWithoutDuplicates.get(j);
					Integer lb1 = rangeElem.getLowerBound();
					Integer ub1 = rangeElem.getUpperBound();
													
					if (lb0 < lb1) {
						lowerB = lb0;
						if (lb1 < ub0 /*&& ub0 < ub1*/) {
							if (ub0 < ub1) {
							upperB = ub1;
							ub0 = ub1;
							}
							else {
								upperB = ub0;
							}
							
							i++;
						} else {
							upperB = ub0;
							
						}
					} else {
						lowerB = lb1;
						if (lb0 < ub1 && ub0 > ub1) {
							upperB = ub0;
						} else {
							upperB = ub1;
						}
					}
					
				 }
				strDisplay.append("[" + lowerB + "," + upperB + "]");
				
			}
			System.out.print("Output Ranges:: " + strDisplay.toString());
		 
		}
		
	}
