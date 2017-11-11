/**
 *
 * CSE 240 Assignment04
 * Program to implement header file for Homework class
 *
 * @author Nikita Bahl
 */
#include <iostream>
#include "Homework.h"
using namespace std;

// Constructor
Data::Data(int *arr, int size)
{
	int i=0;
	this->size = size;
	for (i = 0; i < size; i++)
	{
		this->array[i] = *(arr + i);

	}
}


// Overloading ! to print array
void Data::operator!()
{
	int i=0;
	for (i = 0; i < size; i++)
	{
		cout << this->array[i] << "  ";
	}
    cout<<endl;
}

// Overloading ++ to sort array in ascending order 
void Data::operator++(int s)
{
    cout << endl;
    cout << endl;
	int *pointer = this->array;
	int minindex, i, index;
	for (i = 0; i < this->size - 1; i++)
	{
		minindex = i;
		for (index = (i + 1); index < this->size; index++)
		{
			if (*(pointer + index) < *(pointer + minindex))
			{
				minindex = index;
			}
		}
		int swap = *(pointer + minindex);
		*(pointer + minindex) = *(pointer + i);
		*(pointer + i) = swap;
	}
    cout << endl;
}

// Overloading -- to sort array in descending order
void Data::operator--(int x)
{
	cout << endl;
	int *pointer = this->array;
	int maxindex, i, index;
	for (i = 0; i < this->size - 1; i++)
	{
		maxindex = i;
		for (index = (i + 1); index < this->size; index++)
		{
			if (*(pointer + index) > *(pointer + maxindex))
			{
				maxindex = index;
			}
		}
		int swap = *(pointer + maxindex);
		*(pointer + maxindex) = *(pointer + i);
		*(pointer + i) = swap;
	}
}

// Overloading of + to add value to every element in array
void Data::operator+(int n)
{
	cout << endl;
	int i=0;
	for (i = 0; i < this->size; i++)
	{
		this->array[i] = this->array[i] + n;
	}

}

// Overloading of operator - to subtract value from the array
void Data::operator-(int n)
{
	cout << endl;
	int i = 0, j = 0, k=0;

	for (i = 0; i < this->size; i++)
	{
		if (this->array[i] == n)
		{
			k++;
			for (j = i; j < this->size - 1; j++)
			{
				this->array[j] = this->array[j + 1];
			}
		}
	}
	this->size = this->size - k;
}

// Overloading of operator < : return true if the array has a value lower than the one provided as parameter
bool Data::operator<(int n)
{
	cout << endl;
	int i = 0, j = 0;

	for (i = 0; i < this->size; i++)
	{
		if (this->array[i] < n)
		{
			j++;
		}
	}

	if (j > 0)
	{
		return true;
	}
	else
	{
		return false;
	}
}

// Overloading of operator > : return true if the array has a value greater than the one provided as parameter
bool Data::operator>(int n)
{
	cout << endl;
	int i=0,j=0;

	for (i = 0; i < this->size; i++)
	{
		if (this->array[i] > n)
		{
			j++;
		}
	}

	if (j > 0)
	{
		return true;
	}
	else
	{
		return false;
	}
}

// Overloading of operator == : return true if the array contains the value that is provided as a parameter 
bool Data::operator==(int n)
{
	cout << endl;
	int i = 0, j = 0;

	for (i = 0; i < this->size; i++)
	{
		if (this->array[i] == n)
		{
			j++;
		}
	}

	if (j > 0)
	{
		return true;
	}
	else
	{
		return false;
	}
}

// Overloading of operator * to return each element multiplied by the parameter
Data Data::operator*(int n)
{
	Data d(this->array, this->size);
	cout << endl;
	int i=0;
	for (i = 0; i < this->size; i++)
	{
		d.array[i] = this->array[i] * n;
	}
	return d;
}
