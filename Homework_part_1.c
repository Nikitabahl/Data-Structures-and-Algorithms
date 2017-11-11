/**
 * Program to initialize an array and perform sorting in descending order on it.
 * CSE 240 Assignment02
 * @author Nikita
 */
 #include<stdio.h>
 
   //function to print the 1D array
   void print_array (int array[], int size)
   {
     int i = 0;            
     for(i=0; i<size; i++)
     {
         printf ("%d ", array[i]);            
     }
     printf("\n");
   }

   //function to initialize a 1D array based on positions of the element
   void initialize_array (int array[], int size)
    {
        int i = 0;            
        for(i=0; i<size; i++)
        {
            if (i%2 == 0)
            {
                array[i] = 1;
            }
            else
            {
                array[i] = 0;
            } 
        }
   } 

    //function to perform selection sort on a given array of integers
    void selection_sort (int data[], int size)
    {
        int min, i, find;
        for (i=0; i<size; i++) 
        {
            min = i;
            for (find=i+1; find<size; find++)
            {
                if (data[find] > data[min]) 
                {
                   min = find;
                }
            }
        //swap the two elements, data[minIndex] and data[index]
        int temp = data[min];
        data[min] = data[i];
        data[i] = temp;
        }
        printf("\n");
    }
    
    /*
    * method to find factorial of a number 
    */
    int factorial (int n)
    {
        if ( n == 1 )
        {
            printf("\n");
            return 1;
        }
        else 
        {
            return n * factorial(n-1);  
        }
    }
 
   int main ()
   {
     int a [10] = {3, 5, 6, 8, 12, 13, 16, 17, 18, 20};
     int b [6]= {18, 16, 19, 3 ,14, 6};
     int c [5]= {5, 2, 4, 3, 1};
    
     // testing initialize_array
     print_array(a, 10); // print: 3, 5, 6, 8, 12, 13, 16, 17, 18, 20
     initialize_array(a, 10);
     print_array(a, 10); // print: 1, 0, 1, 0, 1, 0, 1, 0, 1, 0
     // testing initialize_array
     print_array(b, 6); // print: 18, 16, 19, 3 ,14, 6
     selection_sort (b, 6);
     print_array(b, 6); // print: 19, 18, 16, 14, 6, 3
     // testing factorial
     printf("Factorial of 5 - %d\n", factorial (5)); //print: 120
     c[0] = factorial (c[0]);
     c[1] = factorial (c[2]);
     print_array(c, 5); // print: 120, 24, 4, 3, 1

     getch();
     return 0;
   }

