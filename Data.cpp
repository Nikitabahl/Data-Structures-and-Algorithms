
#include <iostream>
#include "Data.h"
using namespace std;

// Data Class Constructor
Data::Data(int *arr, int size)
{
	int i;
	this->len = size;
	for (i = 0; i < size; i++)
	{
		this->a[i] = *(arr + i);

	}
}


// Overloading of unary operator ! to print array element.
void Data::operator!()
{
	int len = this->len ,i;
	for (i = 0; i < len; i++)
	{
		if (i == len - 1)
		{
			cout << this->a[i];
		}
		else
		{
			cout << this->a[i] << ",";
		}
		
	}

}

// Overloading of operator ++ to sort array  in ascending order using Selection Sort
void Data::operator++(int x)
{
	cout << endl;
	int *p = this->a;
	int minindex, i, reqindex;
	for (i = 0; i < this->len - 1; i++)
	{
		minindex = i;
		for (reqindex = (i + 1); reqindex < this->len; reqindex++)
		{
			if (*(p + reqindex) < *(p + minindex))
			{
				minindex = reqindex;
			}
		}
		int swap = *(p + minindex);
		*(p + minindex) = *(p + i);
		*(p + i) = swap;
	}
}

// Overloading of operator -- to sort array in descending order using Selection Sort
void Data::operator--(int x)
{
	cout << endl;
	int *p = this->a;
	int maxindex, i, reqindex;
	for (i = 0; i < this->len - 1; i++)
	{
		maxindex = i;
		for (reqindex = (i + 1); reqindex < this->len; reqindex++)
		{
			if (*(p + reqindex) > *(p + maxindex))
			{
				maxindex = reqindex;
			}
		}
		int swap = *(p + maxindex);
		*(p + maxindex) = *(p + i);
		*(p + i) = swap;
	}
}

// Overloading of operator + to add value in parameter to every element in array
void Data::operator+(int add)
{
	cout << endl;
	int i;
	for (i = 0; i < this->len; i++)
	{
		this->a[i] = this->a[i] + add;
	}

}

// Overloading of operator - to subtract value in parameter to every element in array
void Data::operator-(int sub)
{
	cout << endl;
	int i = 0, j = 0, k=0;

	for (i = 0; i < this->len; i++)
	{
		if (this->a[i] == sub)
		{
			k++;
			for (j = i; j < this->len - 1; j++)
			{
				this->a[j] = this->a[j + 1];
			}
		}
	}
	this->len = this->len - k;

}

// Overloading of operator < : return true if the array has a value lower than the one provided as parameter
bool Data::operator<(int less)
{
	cout << endl;
	int i = 0, j = 0;

	for (i = 0; i < this->len; i++)
	{
		if (this->a[i] < less)
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
bool Data::operator>(int grt)
{
	cout << endl;
	int i=0,j=0;

	for (i = 0; i < this->len; i++)
	{
		if (this->a[i] > grt)
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
bool Data::operator==(int equ)
{
	cout << endl;
	int i = 0, j = 0;

	for (i = 0; i < this->len; i++)
	{
		if (this->a[i] == equ)
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

// Overloading of operator * : return Data object with array member as multiplication of provided parameters -
//a data object and an integer 
Data Data::operator*(int mul)
{
	Data d(this->a, this->len);
	cout << endl;
	int i;
	for (i = 0; i < this->len; i++)
	{
		d.a[i] = this->a[i] * mul;
	}
	return d;
}
