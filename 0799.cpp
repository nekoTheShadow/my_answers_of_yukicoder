#include<iostream>

int main(int argc, char const *argv[]) {
    int a, b, c, d;
    std::cin >> a >> b >> c >> d;

    int ans = 0;
    for (int x = a; x <= b; x++) {
        for (int y = c; y <= d; y++) {
            if (x != y) ans++;
        }
    }

    std::cout << ans << std::endl;
}
