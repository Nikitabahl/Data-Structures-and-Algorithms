/**
 *
 * CSE 240 Assignment03
 * Program to handle auditorium seating arrangements using user input from Assignment.cpp file
 *
 * @author Nikita Bahl
 */
#include "Auditorium.h"
#include<iostream>
#include<string>
using namespace std;

// Global variables to store dimentions of the auditorium
int GlobalRow, GlobalCol;

      //Constructor to create Guest allocation 
      Auditorium::Auditorium(int rowNum, int columnNum) 
      {
        GlobalRow = rowNum;
	    GlobalCol = columnNum;

	    int i;
	    seating = new Guest *[rowNum];
	    for (i = 0; i<rowNum; i++)
	    {
		    seating[i] = new Guest[columnNum]; 
         }  
      }     
      
      //Method to get guest information at particular position
      Guest* Auditorium::getGuestAt(int row, int col)
      {
             return &(seating[row][col]);
      }              
      
      //method to return true/false depending on whether the guest is assigned or not at specified position                        
      bool Auditorium::assignGuestAt (int row, int col, Guest *tempGuest)                        
      {
        if (strcmp(seating[row][col].getFirstName(), "???") || strcmp(seating[row][col].getLastName(), "???"))
        {
            return false;
        }
        else
        {
            seating[row][col] = *tempGuest;
            return true;
        }
      }
      
      //method to check if boundaries entered are valid or not
      bool Auditorium::checkBoundaries(int row, int col)
      {
        if ( (row < 0) || (row > GlobalRow) || (col < 0) || (col > GlobalCol) )
        {
            return false;
        }
        else
        {
            return true;
        }
      }
    
      //method to display the seating arrangement so far in the auditorium   
      char* Auditorium::toString( )
      {
        char *result= new char[1000];
    	strcpy(result,"The Current Seating \n --------------------------\n");
    
    	for ( int i = 0; i < (GlobalRow); i++)
    	{
    		for ( int j = 0; j < (GlobalCol); j++)
    		{
    			strcat(result, (seating[i][j].toString() ));
    			strcat(result, " ");
    		}
    		strcat(result, "\n");
    	}
    	return result;
      }
