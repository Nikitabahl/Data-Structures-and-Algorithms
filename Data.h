
class Data
{
private:
	int a[50];
	int len;

public:
	Data( int *arr, int size);
	void operator!();
	void operator++(int);
	void operator--(int);
	void operator+(int add);
	void operator-(int sub);
	bool operator<(int less);
	bool operator>(int grt);
	bool operator==(int equ);
	Data operator*(int mul);
	
};
