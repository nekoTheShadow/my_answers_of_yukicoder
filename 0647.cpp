#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
	int n;
	cin >> n;
	vector<int> as(n), bs(n);
	for (int i = 0; i < n; i++) cin >> as[i] >> bs[i];

	int m;
	cin >> m;
	vector<int> xs(m), ys(m);
	for (int i = 0; i < m; i++) cin >> xs[i] >> ys[i];

	vector<int> ranks(m, 0);
	int maxx = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (xs[j] <= as[i] && bs[i] <= ys[j]) {
				ranks[j]++;
				maxx = max(ranks[j], maxx);
			}
		}
	}

	vector<int> users;
	if (maxx == 0) {
		cout << 0 << endl;
	} else {
		for (int i = 0; i < m; i++) {
			if (ranks[i] == maxx) {	
				cout << i + 1 << endl;
			}
		}
	}
	
}

