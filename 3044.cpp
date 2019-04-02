#include<iostream>
#include<vector>
#include<numeric>

typedef long long ll;

int main() {
    int n, m;
    std::cin >> n >> m;
    
    std::vector<ll> a(n);
    for (int i = 0; i < n; i++) std::cin >> a[i];

    std::vector<std::vector<ll>> rows(1, std::vector<ll>());
    for (int i = 0; i < n; i++) {
        if (a[i] % 2 == 0) {
            if (!rows.back().empty()) {
                std::vector<ll> row;
                rows.push_back(row);
            }
        } else {
            rows.back().push_back(a[i]);
        }
    }

    for (auto& row : rows) {
        if (row.size() >= m) {
            ll sum = std::accumulate(row.begin(), row.end(), 0LL);
            std::cout << sum << std::endl;
        }
    }
}