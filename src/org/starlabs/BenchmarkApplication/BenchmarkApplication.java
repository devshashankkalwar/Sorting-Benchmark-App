package org.starlabs.BenchmarkApplication;

import java.util.ArrayList;
import java.util.Iterator;


import org.Starlabs.SortingBenchmark.*;



public class BenchmarkApplication {
	public int[] array;
	
	
	public String generateArray(char arrayype, int size){
		switch (arrayype){
		case '1':{
			array = Calculator.createBestCase(size);
			return "Array Generated";
			}
		case '2':{
			array= Calculator.createWorstCase(size);
			return "Array Generated";
			}
		case '3':{
			array= Calculator.generateRandom(size);
			return "Array Generated";
			
			}
		default:{
			return "Please Select Appropriate Case";
			}
		}
	
	}

	public ArrayList<String> Benchmarkmethhod(ArrayList<String> inputlist,int[] array){
		ArrayList<String> outputlist=new ArrayList<String>();
		Iterator<String> iterator = inputlist.iterator();
		while(iterator.hasNext()){
		switch (iterator.next()){
		case "Bubble Sort":{
			Bubblesort obj = new Bubblesort(array);
			outputlist.add("Bubble Sort: "+obj.bubSort());
			break;
			}
		case "Insertion Sort":{
			Insertionsort obj = new Insertionsort(array);
			outputlist.add("Insertion Sort: "+obj.insertSort());
			break;
			}
		case "Selection Sort":{
			Selectionsort obj = new Selectionsort(array);
			outputlist.add("Selection Sort: "+obj.selSort());
			break;
			}
		case "Quick Sort":{
			Quicksort obj= new Quicksort(array);
			outputlist.add("Quick Sort: "+obj.sort());
			break;
			}
		case "Merge Sort":{
			MergeSort obj= new MergeSort(array);
			outputlist.add("Merge Sort: "+obj.sort());
			break;
			}
		}
	}
	return outputlist;
}
}
		


