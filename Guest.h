/**
 *
 * CSE 240 Assignment03
 * Program to create a Guest header file
 *
 * @author Nikita Bahl
 */
class Guest 
{
      private :
              char firstName[30];
              char lastName[30];
              char *temp;
      public : 
             Guest();
             Guest(char* guestInfo) ;
             char* getLastName( ) ;
             char* getFirstName( );
             char* toString( );
};
