#include<iostream>
#include<string>

using namespace std;

int main()
{
	string scores;
	cin >> scores;

	int sum = 0;
	for (char score : scores) sum += (score == '0') ? 10 : (score - '0');

	cout << sum << endl;

    return 0;
}

