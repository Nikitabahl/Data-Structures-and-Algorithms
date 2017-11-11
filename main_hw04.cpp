/**
 *
 * CSE 240 Assignment04
 * Program to create main file for the program
 *
 * @author Nikita Bahl
 */
#include <iostream>
#include "Homework.h"
using namespace std;

int main() {
	int a[10] = { 3, 5, 6, 8, 12, 13, 16, 17, 18, 20 };
	Data data(a, 10);
	!data;
	data++;
	!data;
	data--;
	!data;
	data + 5;
	!data;
	data - 5;
	!data; 
	if (data > 3) // data has a value greater than 3 and return true
	{
		cout << "there is a value greater than 3";
	}
	else
	{
		cout << "fail";
	}
	if (data == 6) // if data has a number 6 in it return true 
	{
		cout << "6 is present in the array!!";
	}
	else
	{
		cout << "search for 6 failed";
	}
	data = data * 5;
	cout << "Product of the array elements - ";
	!data;
	getchar();
    return 0;
}
