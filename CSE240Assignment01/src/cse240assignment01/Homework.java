package cse240assignment01;

/**
 * Program to initialize an array and perform sorting in descending order on it.
 * CSE 240 Assignment01
 * @author Nikita
 */
public class Homework {

    /*
    *method to initialize array by assigning :
    * 1 to even number positions and 0 to odd number positions in the passed array
    */
    public static void initializeArray (int[] array)
    {
        for(int i=0; i<array.length; i++)
        {
            if (i%2 == 0)
                array[i] = 1;
            else
                array[i] = 0;
        }
        System.out.println();
    }
    
    /*
    * method to print an array being passed (here array[])
    */
    public static void printArray (int[] array)
    {
        for(int i=0; i<array.length; i++)
        {
            if (i < array.length-1 )
                System.out.print(array[i]+ ", ");
            else 
                System.out.print(array[i]);
                }
        System.out.println();
    }
    
    /*
    * method to print sort an array being passed (here data[]) using selection sort
    */    
    public static void selectionSort (int[] data)
    {
        int min;
        for (int i=0; i<data.length-1; i++) {
        min = i;
        for (int find=i+1;find<data.length; find++){
        if (data[find] > data[min]) {
        min = find;
        }
        }
        //swap the two elements, data[minIndex] and data[index]
        int temp = data[min];
        data[min] = data[i];
        data[i] = temp;
        }
        System.out.println();
    }
    
    /*
    * method to fidn factorial of a number 
    */
    public static int factorial (int n)
    {
        if ( n == 1 )
        {
            System.out.println();
            return 1;
        }
        else 
            return n * factorial(n-1);  
    }
    
    public static void main(String[] args) {
        
        int [] a = {3, 5, 6, 8, 12, 13, 16, 17, 18, 20};
        int [] b = {18, 16, 19, 3 ,14, 6};
        int [] c = {5, 2, 4, 3, 1};
        // testing initializeArray
        printArray(a); // print: 3, 5, 6, 8, 12, 13, 16, 17, 18, 20
        initializeArray(a);
        printArray(a); // print: 1, 0, 1, 0, 1, 0, 1, 0, 1, 0
        // testing initializeArray
        printArray(b); // print: 18, 16, 19, 3 ,14, 6
        selectionSort (b);
        printArray(b); // print: 19, 18, 16, 14, 6, 3
        // testing factorial
        System.out.println (factorial (5)); //print: 120
        c[0] = factorial (c[0]);
        c[1] = factorial (c[2]);
        printArray(c); // print: 120, 24, 4, 3, 1
    }
    
}
