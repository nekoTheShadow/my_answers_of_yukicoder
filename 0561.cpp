#include<iostream>
#include<vector>
#include<climits>

typedef long long ll;

int main(int argc, char const *argv[]) {
    ll n, d;
    std::cin >> n >> d;
    std::vector<ll> t(n), k(n);
    for (int i = 0; i < n; i++) {
        std::cin >> t[i] >> k[i];
    }

    std::vector<std::vector<ll>> dp(2, std::vector<ll>(n + 1, LLONG_MIN));
    dp[0][0] = 0;
    dp[1][0] = -d;
    for (ll j = 0; j < n; j++) {
        for (ll i = 0; i < n; i++) {
            if (i == 0) {
                dp[0][j + 1] = std::max(dp[0][j + 1], dp[0][j] + t[j]);
                dp[1][j + 1] = std::max(dp[1][j + 1], dp[0][j] + k[j] - d);
            } else {
                dp[0][j + 1] = std::max(dp[0][j + 1], dp[1][j] + t[j] - d);
                dp[1][j + 1] = std::max(dp[1][j + 1], dp[1][j] + k[j]);
            }
        }
    }

    ll ans = std::max(dp[0][n], dp[1][n]);
    std::cout << ans << std::endl;
}
