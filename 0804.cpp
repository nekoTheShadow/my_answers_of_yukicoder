#include<iostream>
#include<algorithm>

int main() {
    int a, b, c, d;
    std::cin >> a >> b >> c >> d;
    int ans = 0;
    for (int x = 0; x <= a; x++) {
        if (c * x <= b && x + c * x <= d) ans = std::max(ans, x);
    }
    std::cout << ans << std::endl;
}