/**
 * Program to make an auditorium arrangement and assign guests to each seat
 * CSE 240 Assignment01
 * @author Nikita Bahl
 */
#include <stdio.h>
#include<string.h> // library to use copy and string compare standard functions.

//global variables for row and column count of the auditorium
int globalRowNum = 0;
int globalColumnNum = 0;

//structure to store guest information
struct guest {
char last_name[30] ;
char first_name[30];
};

//structure to store auditorium seating for guest 
struct auditorium_seating {
struct guest **seating;
};

//function to assign default values to first_name and last_name for each guest in the auditorium.
void guest_init_default (struct guest *g )
{
     strcpy(g->last_name, "???");
     strcpy(g->first_name, "???");
}

//function to split the firstname and lastname of each guest from an input string such as Nikita/Bahl
void guest_init (struct guest *g, char *info) 
{
      char separator[1] = "/";
      char* word;
      word = strtok(info, separator);
      strcpy(g->first_name, word);
      word = strtok(NULL, separator);
      strcpy(g->last_name, word);      
}

//function to return the initials of the guest assigned at a particular location
void guest_to_string (struct guest *g ) 
{
     printf(" %c.%c. ", g->first_name[0] , g->last_name[0] );
}

//function to create the auditorium seating arrangement and assigning default values to each seat
void auditorium_seating_init (int rowNum, int columnNum, struct auditorium_seating *a ) 
{
     int i, j;
     a->seating = (struct guest**) malloc (rowNum* sizeof(struct guest));
     for( i=0 ; i< rowNum; i++)
     {
         a->seating[i] = (struct guest*) malloc (columnNum* sizeof(struct guest)); 
     }     
     
     for (  i = 0; i< rowNum; i++)
     {
         for ( j = 0; j< columnNum ; j++)
         {
             guest_init_default( &(a->seating[i][j]) );   
         }
     }
}

//function to assign guest at a particular location gthe auditorium if it is empty or else it is not assigned.
int assign_guest_at (int row, int col, struct auditorium_seating *a, struct guest* g)
{
    if (strcmp(a->seating[row][col].first_name, "???") || strcmp(a->seating[row][col].last_name, "???"))
        {
            return 0;
        }
        else
        {
            strcpy(a->seating[row][col].first_name, g->first_name);
            strcpy(a->seating[row][col].last_name, g->last_name);
            return 1;
        } 
}

//function to check if boundaries of the auditorium seating arranagement.
int check_boundaries (int row, int col, struct auditorium_seating *a)
{
     if ( (row < 0) || (row > globalRowNum)|| (col < 0) || (col > globalColumnNum ) )
        {
            return 0;
        }
        else
        {
            return 1;
        }
         
}

//function to print the auditorium seating arrangement.
void auditorium_seating_to_string (struct auditorium_seating *a ) 
{
     printf("The current seating \n -------------------- \n"); 
     
     int i,j;
     for ( i =0; i< globalRowNum ; i++)
     {
         for (j = 0; j< globalColumnNum ; j++)
         {
             guest_to_string(& (a->seating[i][j]) );
         }
      printf("\n");   
     }
}

int main() 
{
     //defining structure variables for temp_guest and auditorium_seating
     struct auditorium_seating auditorium_seating;
     struct guest temp_guest;
    
     int row, col, rowNum, columnNum;
    
     char guest_info[30];
    
     // Ask a user to enter a number of rows for an auditorium seating
     printf ("Please enter a number of rows for an auditorium seating.");
     scanf ("%d", &rowNum);
    
     // Ask a user to enter a number of columns for an auditorium seating
     printf ("Please enter a number of columns for an auditorium seating.");
     scanf ("%d", &columnNum);
     
     //global variables are assigned values for row and column
     globalColumnNum = columnNum;
     globalRowNum = rowNum;
 
     // auditorium_seating
     auditorium_seating_init(rowNum, columnNum, &auditorium_seating);
    
     printf("Please enter a guest information or enter \"Q\" to quit.");
     /*** reading a guest's information ***/
     
     scanf ("%s", guest_info);
     /* we will read line by line **/
     
     //loop to check if the user has entered Quit or not. 
     while ( strcmp(guest_info, "Q") )
     {
         printf ("\nA guest information is read.\n");
         // printing information.
         printf ("%s", guest_info);
         // guest
         guest_init (&temp_guest, guest_info);
         // Ask a user to decide where to seat a guest by asking
         // for row and column of a seat
         printf ("\nPlease enter a row number where the guest wants to sit.");
         scanf("%d", &row);
         printf("\nPlease enter a column number where the guest wants to sit.");
         scanf("%d", &col);
         
        // Checking if the row number and column number are valid
        // (exist in the theatre that we created.)
         if (check_boundaries(row, col, &auditorium_seating) == 0) 
         {
             printf("\nrow or column number is not valid.");
             printf("\nA guest %s %s is not assigned a seat.", temp_guest.first_name, temp_guest.last_name);
         } 
         else 
         {
             // Assigning a seat for a guest
             if (assign_guest_at(row, col, &auditorium_seating, &temp_guest) == 1)
             {
                 printf("\nThe seat at row %d and column %d is assigned to the guest",row, col);
                 guest_to_string(&temp_guest);
                 printf("\n");
                 printf("\n");
                 auditorium_seating_to_string(&auditorium_seating);
             } 
             else 
             {
                  printf("\nThe seat at row %d and column %d is taken.", row, col);
             }
         }
         
         // Read the next guestInfo
         printf ("Please enter a guest information or enter \"Q\" to quit.");
         /*** reading a guest's information ***/
         scanf("%s", guest_info);
     } 
   return 0;
}
