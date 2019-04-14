#include<iostream>
#include<vector>

int main() {
    int n, k;
    std::cin >> n >> k;
    
    std::vector<int> v = {1};
    int c = 1;
    for (int i = 0; i < n - 1; i++) {
        int a;
        std::cin >> a;
        if (k < a) c++;
        v.push_back(c);
    }

    for (int e : v) std::cout << e << std::endl;
}