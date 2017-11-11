/**
 *
 * CSE 240 Assignment01
 * Program to handle auditorium seating arrangements using user input from Assignment.java file
 * @author Nikita Bahl
 */
package cse240assignment01;

public class AuditoriumSeating {
   //2D array of type Guest to store seating arrangement of the guests in the auditorium
    private final Guest[][] seating; 
   
    //constructor to instantiate the array of objects 
    public AuditoriumSeating (int rowNum, int columnNum) 
    {
        seating = new Guest[rowNum][columnNum];
        for ( int i = 0; i< rowNum; i++)
        {
            for (int j = 0; j< columnNum ; j++)
            {
                seating[i][j] = new Guest();
            }
        }
    }

    //method to return guest information at particular location
    private Guest getGuestAt(int row, int col)
    {
        return seating[row][col];
    }

    
    public boolean assignGuestAt(int row, int col, Guest tempGuest)
    {
        if ((seating[row][col].firstName == "???" ) && (seating[row][col].lastName == "???"))
        {
            seating[row][col] = tempGuest;
            return true;
        }
        else
        {
            return false;
        }
    }

    // method to check if the guest location in within the auditorium boundaries or not
    public boolean checkBoundaries (int row, int col)
    {
        int arrayRow = seating.length;
        int arrayCol = seating[0].length;
        if ( (row < 0) || (row > arrayRow) || (col < 0) || (col > arrayCol) )
        {
            return false;
        }
        else
        {
            return true;
        }
    }  
    
    // method to display seating arrangement in auditorium with current seating spaces availabe and guest occupancies
    @Override
    public String toString( ) 
    {
        String result = "";
        for (int i = 0; i <seating.length ; i++)
        {
            for (int j = 0; j<seating[0].length ; j++)
            {
                result = result + " " + seating[i][j].toString();
            }
            result = result + "\n";
        }
        return result;
    }
    
}