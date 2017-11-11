/**
 *
 * CSE 240 Assignment04
 * Program to create header file for Homework class
 *
 * @author Nikita Bahl
 */
class Data
{
private:
	int array[100];
	int size;

public:
	Data( int *arr, int size);
	void operator!();
	void operator++(int);
	void operator--(int);
	void operator+(int n);
	void operator-(int n);
	bool operator<(int n);
	bool operator>(int n);
	bool operator==(int n);
	Data operator*(int n);
	
};
