#include<iostream>
#include<set>

typedef long long ll;

int main(int argc, char const *argv[]) {
    ll n;
    std::cin >> n;

    std::set<ll> s;
    for (ll x = 0; ; x++) {
        ll t = 1LL << x;
        if (n < t) break;
        s.insert(t);
    }

    for (ll a = 1; a < n; a++) {
        ll b = n - a;
        if (s.count(a) == 0 && s.count(b) == 0) {
            std::cout << a << " " << b << std::endl;
            return 0;
        }
    }

    std::cout << -1 << std::endl;
}
