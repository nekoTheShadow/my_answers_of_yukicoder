#include<iostream>
#include<vector>
#include<string>

using namespace std;

int fizzbuzz(int x) {
	if (x % 15 == 0) return 8; // FizzBuzz
	if (x % 3 == 0 || x % 5 == 0) return 4;  // Fizz or Buzz
	return to_string(x).size();
}

int main() {
	int a, sum = 0;
	while (cin >> a) sum += fizzbuzz(a);
	cout << sum << endl;
    return 0;
}

