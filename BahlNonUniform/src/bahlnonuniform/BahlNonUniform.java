/*
 * Program to check the doubling formula for selection and insertion sort
 * 
 * @author Nikita, Acuna, Sedgewick and Wayne 
 * @version 1.0 (03/10/2017)
 */
package bahlnonuniform;

import java.util.*;

//class to capture the time elapsed for the algorithm
class Stopwatch { 
  private final long start;

  //constructor for StopWatch
  public Stopwatch() {
    start = System.currentTimeMillis();
  } 

  //method to calculate time elapsed
  public double elapsedTime() {
    long now = System.currentTimeMillis();
    return (now - start) / 1000.0;
  }
} 

class InsertionSort
{
    //methos used to sort an array of integers
    public static void sort(int[] array) 
    {
        for( int i = 0 ;i < array.length ; i++ ) 
        {
            int temp = array[ i ];    
            int j = i;
            while(  j > 0  && temp < array[ j -1]) 
            {
                array[ j ] = array[ j-1];   
                j= j - 1;
            }
            array[ j ] = temp;       
        }  
    }
}

class SelectionSort
{
    //method used to sort an array of integers
    public static void sort(int[] arr) {
        int n = arr.length;
 
        for (int i = 0; i < n-1; i++)
        {
            int min = i;
            for (int j = i+1; j < n; j++)
            {
                if (arr[j] < arr[min])
                {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}

public class BahlNonUniform {

    //method used to generate random numbers between two given integers
    public static int randBetween(int l, int u)
    {
        Random rand = new Random ();
        int value = rand.nextInt (u-l+1) + l;
        return value;
    }
    
    //method to generate dataSet1 value of integers
    public static int[] dataSet1 (int n)
    {
        int array[] = new int[n];
        
        for( int i=0; i<n; i++)
        {
            if(i<=n/2)
            {
                array[i] = 0;
            }
            else
            {
                array[i] = 1;
            }
        }
        return RandomizeArray(array);
    }
    
    //method to generate dataSet2 value of integers
    static int[] dataSet2 (int n)
    {
        
        int array[] = new int[n];
        int low = 0, mid = n/2;
        int value = 0;
        for( int i=0; i<n; i++)
        {
            if(i<mid)
            {
                array[i] = value;
            }
            else if (i>=mid && i<n)
            {
                value = value + 1;
                low = mid;
                mid = low + ((n - mid)/2);
                array[i] = value;
            }
        }
        return RandomizeArray(array);
    
    }
    
    //method to generate dataSet3 value of integers
    static int[] dataSet3 (int n)
    {
        int array[] = new int[n];
        
        for( int i=0; i<n; i++)
        {
            if(i<=n/2)
            {
                array[i] = 0;
            }
            else
            {
                array[i] = randBetween(1,n);
            }
        }
        return RandomizeArray(array);
    }
    
    //methos to randomize the array elements in an array of integers.
    public static int[] RandomizeArray(int[] array)
    {
        Random rand = new Random();  		
 	for (int i=0; i<array.length; i++) 
            {
                // new random position
                int Position = rand.nextInt(array.length); 
		
                //swapping random number positions
                int temp = array[i];
		array[i] = array[Position];
		array[Position] = temp;
	    }
        
 	return array;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
       System.out.println("Performing SELECTION SORT on different data sets!");
       
       System.out.println();
       System.out.println("For function 1 having size 2048 :");
       Stopwatch stopwatch = new Stopwatch();
       int[] data1 = dataSet1(2048);            
       SelectionSort.sort(data1);
       double time = stopwatch.elapsedTime();
       System.out.println("   Time elapsed : " + time);
       
       System.out.println("For function 1 having size 4096 :");
       Stopwatch stopwatch2 = new Stopwatch();
       int[] data2 = dataSet1(4096);       
       SelectionSort.sort(data2);
       double time2 = stopwatch2.elapsedTime();
       System.out.println("   Time elapsed : " + time2);
       
       System.out.println("Using doubling formula for function 1 using selection sort : ");
       System.out.print((Math.log(time2/time)/Math.log(2)));
       System.out.println();
       System.out.println();
       System.out.println("For function 2 having size 2048 :");
       Stopwatch stopwatch3 = new Stopwatch();
       int[] data3 = dataSet2(2048);            
       SelectionSort.sort(data3);
       double time3 = stopwatch3.elapsedTime();
       System.out.println("   Time elapsed : " + time3);
       System.out.println("For function 2 having size 4096 :");
       
       Stopwatch stopwatch4 = new Stopwatch();
       int[] data4 = dataSet2(4096);       
       SelectionSort.sort(data2);
       double time4 = stopwatch4.elapsedTime();
       System.out.println("   Time elapsed : " + time4);
       
       System.out.println("Using doubling formula for function 1 using selection sort : ");
       System.out.print((Math.log(time4/time3)/Math.log(2)));
       System.out.println();
       System.out.println();
       
       System.out.println();
       System.out.println("For function 3 having size 2048 :");
       Stopwatch stopwatch5 = new Stopwatch();
       int[] data5 = dataSet3(2048);            
       SelectionSort.sort(data5);
       double time5 = stopwatch5.elapsedTime();
       System.out.println("   Time elapsed : " + time5);
       System.out.println("For function 3 having size 4096 :");
       
       Stopwatch stopwatch6 = new Stopwatch();
       int[] data6 = dataSet3(4096);       
       SelectionSort.sort(data6);
       double time6 = stopwatch6.elapsedTime();
       System.out.println("   Time elapsed : " + time6);
       
       System.out.println("Using doubling formula for function 1 using selection sort : ");
       System.out.print((Math.log(time6/time5)/Math.log(2)));
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println();
       
       System.out.println("Hypothesis for Selection Sort :");
       System.out.println("   1. The elements are moved only once per sorting of the code. The value for doubling formula is turning out to be a constant which is approximately 2. ");
       System.out.println("   2. Big-Oh is O(N^2) as the doubling formula gives us 2 as worst and 1 or lesser at best ");
       System.out.println("   3. The selection sort is insensitive to data. Even if only one swap is needed to sort, the Big-Oh remains O(N^2) ");

       System.out.println();
       System.out.println();
       System.out.println();       
       
       
       System.out.println("Performing INSERTION SORT on different data sets!");
       
       System.out.println();
       System.out.println("For function 1 having size 2048 :");
       Stopwatch stopwatch7 = new Stopwatch();
       int[] data7 = dataSet1(2048);            
       InsertionSort.sort(data7);
       double time7 = stopwatch7.elapsedTime();
       System.out.println("   Time elapsed : " + time7);
       System.out.println("For function 1 having size 4096 :");
       
       Stopwatch stopwatch8 = new Stopwatch();
       int[] data8 = dataSet1(4096);       
       InsertionSort.sort(data8);
       double time8 = stopwatch8.elapsedTime();
       System.out.println("   Time elapsed : " + time8);
       
       System.out.println("Using doubling formula for function 1 using insertion sort : ");
       System.out.print((Math.log(time8/time7)/Math.log(2)));
       System.out.println();
       System.out.println();
       System.out.println("For function 2 having size 2048 :");
       Stopwatch stopwatch9 = new Stopwatch();
       int[] data9 = dataSet2(2048);            
       InsertionSort.sort(data9);
       double time9 = stopwatch9.elapsedTime();
       System.out.println("   Time elapsed : " + time9);
       System.out.println("For function 2 having size 4096 :");
       
       Stopwatch stopwatch10 = new Stopwatch();
       int[] data10 = dataSet2(4096);       
       InsertionSort.sort(data10);
       double time10 = stopwatch10.elapsedTime();
       System.out.println("   Time elapsed : " + time10);
       
       System.out.println("Using doubling formula for function 1 using insertion sort : ");
       System.out.print((Math.log(time10/time9)/Math.log(2)));
       System.out.println();
       System.out.println();
       
       System.out.println();
       System.out.println("For function 3 having size 2048 :");
       Stopwatch stopwatch11 = new Stopwatch();
       int[] data11= dataSet3(2048);            
       InsertionSort.sort(data11);
       double time11 = stopwatch11.elapsedTime();
       System.out.println("   Time elapsed : " + time11);
       System.out.println("For function 3 having size 4096 :");
       
       Stopwatch stopwatch12 = new Stopwatch();
       int[] data12 = dataSet3(4096);       
       InsertionSort.sort(data12);
       double time12 = stopwatch12.elapsedTime();
       System.out.println("   Time elapsed : " + time12);
       
       System.out.println("Using doubling formula for function 1 using insertion sort : ");
       System.out.print((Math.log(time12/time11)/Math.log(2)));
       System.out.println();
       System.out.println();
       
       System.out.println("Hypothesis for Insertion Sort :");
       System.out.println("   1. The value for doubling formula is turning out to be a constant which is approximately 2. ");
       System.out.println("   2. Big-Oh is O(N^2) -> (for example a reverse sorted array) and best case is O(N) when the array is partially sorted.  ");
       System.out.println("   3. The insertion sort is sensitive to data. The maximum swaps is turning out to be (N^2)/2 and the minimum swaps is (N^2)/4 ");
       System.out.println("   4. The minimum comparisons are (N-1) and maximum comparisons are (N^2)/2");
    }
}
