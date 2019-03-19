#include<iostream>
#include<vector>

int main(int argc, char const *argv[]) {
    // x^2 + y^2 = D+ w^2 - z^2
    int n, d;
    std::cin >> n >> d;

    std::vector<int> c(n * n * 2 + 1, 0);
    for (int x = 1; x <= n; x++) {
        for (int y = 1; y <= n; y++) {
            c[x * x + y * y]++;
        }
    }

    int ans = 0;
    for (int w = 1; w <= n; w++) {
        for (int z = 1; z <= n; z++) {
            int k = d + w * w - z * z;
            if (0 <= k && k < c.size()) ans += c[k];
        }
    }
    
    std::cout << ans << std::endl;
    return 0;
}


