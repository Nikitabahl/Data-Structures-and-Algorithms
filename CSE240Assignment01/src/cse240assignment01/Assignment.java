package cse240assignment01;
import java.util.Scanner;
/**
 *
* CSE 240 Assignment01
 * Program to take guest names as input from user and assign a particular location in the auditorium
 * @author Nikita Bahl
 */
public class Assignment {
    public static void main(String[] args) {
    AuditoriumSeating auditoriumSeating;
    Guest tempGuest;
    int row, col, rowNum, columnNum;
    String guestInfo;
    Scanner scan = new Scanner(System.in);
    // Ask a user to enter a number of rows for an auditorium seating
    System.out.println
    ("Please enter a number of rows for an auditorium seating.");
    rowNum = scan.nextInt();

    // Ask a user to enter a number of columns for an auditorium seating
    System.out.println
    ("Please enter a number of columns for an auditorium seating.");
    columnNum = scan.nextInt();
    // instantiate a AuditoriumSeating object
    auditoriumSeating = new AuditoriumSeating(rowNum, columnNum);

    System.out.println
    ("Please enter a guest information or enter \"Q\" to quit.");
    /*** reading a guest's information ***/
    guestInfo = scan.next();
    /* we will read line by line **/
    while (!guestInfo.equalsIgnoreCase("Q")){
    System.out.println("\nA guest information is read.");
    // printing information read from a file.
    System.out.println(guestInfo);
    // creating a guest object using the guest information from a user
    tempGuest = new Guest(guestInfo);
    // Ask a user to decide where to seat a guest by asking
    // for row and column of a seat    
    System.out.println
    ("Please enter a row number where the guest wants to sit."); row =
    scan.nextInt();
    System.out.println
    ("Please enter a column number where the guest wants to sit.");
    col = scan.nextInt();
    // Checking if the row number and column number are valid
   // (exist in the theatre that we created.)
    if (auditoriumSeating.checkBoundaries(row, col) == false) {
    System.out.println("\nrow or column number is not valid.");
    System.out.println ("A guest " + tempGuest.getFirstName() +
    " " + tempGuest.getLastName() + " is not assigned a seat.");
    } else {
    // Assigning a seat for a guest
    if (auditoriumSeating.assignGuestAt(row,col,tempGuest) == true){
    System.out.println("\nThe seat at row " + row +" and column " +
    col + " is assigned to the guest " + tempGuest.toString());
    System.out.println(auditoriumSeating);
    } else {
    System.out.println("\nThe seat at row " + row + " and column " +
    col + " is taken.");
    }
    }
            
    // Read the next guestInfo
    System.out.println
    ("Please enter a guest information or enter \"Q\" to quit.");
    /*** reading a guest's information ***/
    guestInfo = scan.next();
    }
    }
}
