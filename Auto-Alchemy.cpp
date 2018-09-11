#include <iostream>
#include <windows.h>
#include <cstdlib>
using namespace std;


int main(int argc, char * argv[])

{
	int x;
	int y;
	int number;
	int count;


start:

	cout << "How many times do you wish to click?" << endl;
	cout << " : ";

	cin >> number;

	count = 0;

	cout << "Starting in 5..." << endl;
	Sleep(1000);
	cout << "Starting in 4..." << endl;
	Sleep(1000);
	cout << "Starting in 3..." << endl;
	Sleep(1000);
	cout << "Starting in 2..." << endl;
	Sleep(1000);
	cout << "Starting in 1..." << endl;
	Sleep(1000);

	while (count <= number)
	{
		Sleep((rand()%2 + 1) * 500);
		mouse_event(MOUSEEVENTF_LEFTDOWN, 0, 0, 0, 0);
		mouse_event(MOUSEEVENTF_LEFTUP, 0, 0, 0, 0);
		count++;
	}
}