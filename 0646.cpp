#include<iostream>

using namespace std;

int main()
{
	int n;
	cin >> n;

	for (int x = n; x > 0; x--) {
		for (int y = 0; y < x; y++) cout << n;
		cout << endl;
	}
	
    return 0;
}

