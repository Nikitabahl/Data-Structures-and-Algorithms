/**
 *
 * CSE 240 Assignment03
 * Program to create a Guest header file
 * @author Nikita Bahl
 */
#include "Guest.h"

class Auditorium  
{
      private :
              Guest **seating;      //2D array to store guest information
      
      public:
             
             Auditorium(int rowNum, int columnNum) ;
             Guest* getGuestAt(int row, int col) ;
             bool assignGuestAt(int row, int col, Guest *tempGuest);
             bool checkBoundaries(int row, int col) ;
             char* toString( ) ;
             
};
              
