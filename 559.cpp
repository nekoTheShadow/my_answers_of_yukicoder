#include<iostream>
#include<string>

using namespace std;

int main() {
	string s;
	cin >> s;

	int cnt = 0, a = 0;
	for (char c : s) {
		if (c == 'A') {
			cnt += a;
		} else {
			a++;
		}
	}

	cout << cnt << endl;

    return 0;
}

