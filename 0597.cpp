#include<iostream>
#include<string>
#include<sstream>

using namespace std;

int main() {
	stringstream ss;

	int x;
	string s;

	cin >> x;
	for (int i = 0; i < x; i++) {
		cin >> s;
		ss << s;
	}

	cout << ss.str() << endl;

    return 0;
}

