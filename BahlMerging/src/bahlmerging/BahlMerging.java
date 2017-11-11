/**
 * Implements various merge style algorithms.
 * 
 * @author (Nikita Bahl), Acuna
 * @verison (10/21/2017)
 */
package bahlmerging;

import java.util.Arrays;
import java.util.Random;

public class BahlMerging {
     
    /**
     * Entry point for sample output.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue q1 = new ListQueue(); q1.enqueue("T"); q1.enqueue("R"); q1.enqueue("O"); q1.enqueue("L"); q1.enqueue("E");
        Queue q2 = new ListQueue(); q2.enqueue("X"); q2.enqueue("S"); q2.enqueue("P"); q2.enqueue("M"); q2.enqueue("E"); q2.enqueue("A");        

        //Q1
        Queue merged = mergeQueues(q1, q2);
        System.out.println(merged.toString());
        
        //Q2
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert isSorted(a);
        show(a);
        
        //Q3
        String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        shuffle(b);
        //show(b);
        
        //shuffle(b);
        //show(b);
    }
    
    //method to merge two queues and resturn the resultant queue
    public static Queue mergeQueues(Queue q1, Queue q2) 
    {
        Queue result = new ListQueue();
        if (!q1.isEmpty() && !q2.isEmpty()) 
        {
            String a = q1.dequeue().toString();
            String b = q2.dequeue().toString();
            while (true) 
            {
                if (a.compareTo(b) <0) 
                {
                    result.enqueue(a);
                    if (q1.isEmpty()) 
                    {
                        result.enqueue(b);
                        break;
                    }
                    a = q1.dequeue().toString();
                } 
                else 
                {
                    result.enqueue(b);
                    if (q2.isEmpty()) 
                    {
                        result.enqueue(a);
                        break;
                    }
                    b = q2.dequeue().toString();
                }
            }
        }
        while (!q1.isEmpty()) 
        {
            String a = q1.dequeue().toString();
            result.enqueue(a);
        }
        while (!q2.isEmpty()) 
        {
            String b = q2.dequeue().toString();
            result.enqueue(b);
        }
        return result;
    }
    
    // function to generate random numbers between two values.
    public static int randBetween(int l, int u)
    {
        Random rand = new Random ();
        int value = rand.nextInt (u-l+1) + l;
        return value;
    }
    
    //method to shuffle an array
    public static void shuffle(Object[] b) 
    {
        if(b.length >1)
        {
            int n = b.length/2;
            Object[] first = new Object[n];
            Object[] second = new Object[b.length-n];
            for (int i=0; i<b.length;i++)
            {
                if (i<n)
                {
                    first[i] = b[i];                    
                }
                else
                {
                    second[i-n] = b[i];
                }
            }
            merge(first,second);
        }
    }
    
    //method to merge two objects based on random numbers generated.
    public static void merge(Object[] b, Object[] c)
    {
        int left = b.length;
        int right = c.length;
        int i=0,j=0,k=0;
        Object[] result = new Object[left+right];
        while (i<left && j<right)
        {
            int a= randBetween(1,10);
            if (a>5)
            {
                result[k++] = b[i++];
            }
            
            if (a<=5)
            {
                result[k++] = c[j++];
            }
            
        }
      while(j<right)
            {
                result[k++] = c[j++];
            }
      while(i<left)
       {
                result[k++] = b[i++];
       }
      
      for(int x=0;x<result.length;x++)
          System.out.print(result[x]+" ");
    }
    
    //method to call merge sort algorithm
    public static void sort(Comparable[] a) 
    {
        a = mergesort(a);
        
        for (Comparable a1 : a)
            System.out.print(a1 + " ");
        
        System.out.println();
    }
    
    //method to implement merge sort
    public static Comparable[] mergesort(Comparable[] a)
    {
        if (a.length == 1)
            return a;
        else
        {
            int low = 0;
            int high = a.length;
            int mid = low + ((high-low)/2);

            Comparable[] first = new Comparable[mid];
            Comparable[] second = new Comparable[high-mid];

            for (int i=0; i<high; i++)
            {
                if (i <mid)
                {first[i] = a[i];}
                else
                {second [i-mid] = a[i];}
            }
        return (Comparable[])merge(mergesort(first), mergesort(second));   
        }
    }
    
    //method to merge two objects of Comparable interface
    public static Comparable[] merge(Comparable[] a, Comparable[] b)
    {
        int left = a.length;
        int right = b.length;
        int i=0,j=0,k=0;
        Comparable[] result = new Comparable[left+right];
        while (i<left && j<right)
        {
            if (less(b[j],a[i])) 
            {
                result[k++] = b[j++];
            }
            else
            {
                result[k++] = a[i++];
            }           
        }
        while(i<left)
            {
                result[k++] = a[i++];
            }
            
      while(j<right)
            {
                result[k++] = b[j++];
            }
        return result;
    }    
    
    //sorting helper from text
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //sorting helper from text
    private static void show(Comparable[] a) {
        for (Comparable a1 : a)
            System.out.print(a1 + " ");

        System.out.println();
    }
    
    //sorting helper from text
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        
        return true;
    }
}