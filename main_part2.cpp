/**
 *
 * CSE 240 Assignment03
 * Program to test the Auditorium seating arrangement
 *
 * @author Nikita Bahl
 */

#include<iostream>
#include <string>
#include "Auditorium.h"

using namespace std;

int main() {
	Auditorium* auditorium;
	Guest* tempGuest;
	int row, col, rowNum, columnNum;
	char guestInfo[30];

	// Ask a user to enter a number of rows for an auditorium seating
	cout << "Please enter a number of rows for an auditorium seating." << endl;
	cin >> rowNum;
	// Ask a user to enter a number of columns for an auditorium seating
	cout << "Please enter a number of columns for an auditorium seating." << endl;
	cin >> columnNum;
	
	// auditorium_seating
	auditorium = new Auditorium(rowNum, columnNum);
	
	cout << "Please enter a guest information or enter \"Q\" to quit." << endl;
	/*** reading a guest's information ***/
	cin >> guestInfo;
	/* we will read line by line **/

	while ((strcmp(guestInfo, "Q") != 0 && strcmp(guestInfo, "q") != 0)) {
		
		cout << "\nA guest information is read."<< endl;
		// printing information.
		cout << guestInfo;
		// guest
		tempGuest = new Guest(guestInfo);
		
		// Ask a user to decide where to seat a guest by asking
		// for row and column of a seat
		cout << "\nPlease enter a row number where the guest wants to sit." << endl;
		cin >> row;
		cout << "\nPlease enter a column number where the guest wants to sit." << endl;
		cin >> col;
		
		// Checking if the row number and column number are valid
		// (exist in the theatre that we created.)
		if ((*auditorium).checkBoundaries(row, col) == false) {
			cout << "\nrow or column number is not valid."<<endl;
			cout << "A guest " << (*tempGuest).getFirstName() << " " <<
				(*tempGuest).getLastName() << " is not assigned a seat."<<endl;
		}
		else {
		// Assigning a seat for a guest
			if ((*auditorium).assignGuestAt(row, col, tempGuest) == true) {
				cout << "\nThe seat at row " << row << " and column " << col <<
					" is assigned to the guest, " << (*tempGuest).toString() << endl;
				cout << (*auditorium).toString();
			}
			else {
				cout << "\nThe seat at row " << row << " and column " << col << " is taken." << endl;
			}
		}
		
		// Read the next guestInfo
		cout << "Please enter a guest information or enter \"Q\" to quit."<<endl;
		/*** reading a guest's information ***/
		cin >> guestInfo;
	}
	getchar();
    return 0;
	
}
