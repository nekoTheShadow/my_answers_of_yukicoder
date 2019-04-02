#include<iostream>

typedef unsigned long long ll;

int main() {
    ll n, m;
    std::cin >> n >> m;

    if (m <= n) {
        std::cout << 0 << std::endl;
    } else {
        ll fact = 1;
        for (ll i = 1; i <= n; i++) {
            fact *= i;
            fact %= m;
        }
        std::cout << fact << std::endl;
    }
}