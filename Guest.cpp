/**
 *
 * CSE 240 Assignment03
 * Program to handle guest information using user input 
 *
 * @author Nikita Bahl
 */

#include<iostream>
#include "Guest.h"
using namespace std;

      //Guest class default constructor to assign default values to each seat
     Guest::Guest()
        {
            strcpy(firstName, "???");
            strcpy(lastName , "???");
        }
      //Parameterized constructor to separate firstname and lastname frm given input  
     Guest::Guest(char* guestInfo)
        {
          char separator[2] = "/";
          char* word;
          word = strtok(guestInfo, separator);
          strcpy(firstName, word);
          word = strtok(NULL, separator);
          strcpy(lastName, word);            
        }

      //method to get last name of guest  
      char* Guest::getLastName ( )
         {
              return lastName;
         }
         
      //method to get first name of guest
       char* Guest::getFirstName ( )
         {
              return firstName;
         }
    
         //method to return initials of the guest
       char* Guest::toString ( ) 
          {
              char *initials = new char[4];
              initials[0] = firstName[0];
              initials[1] = '.';
              initials[2] = lastName[0];
              initials[3] = '.';
              
              return initials;
          }
