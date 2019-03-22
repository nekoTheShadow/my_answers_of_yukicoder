#include<iostream>
#include<vector>
#include<algorithm>

int main() {
    int n;
    std::cin >> n;

    std::vector<int> c(n, 0);
    for (int i = 0; i < n - 1; i++) {
        int a, b;
        std::cin >> a >> b;
        a--;
        b--;
        c[a]++;
        c[b]++;
    }

    int x = std::count_if(c.begin(), c.end(), [&](int v){ return v == 1; });
    std::cout << x - 2 << std::endl;
}