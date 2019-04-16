#include<iostream>

int main() {
    int a, b;
    std::cin >> a >> b;
    int c = 0;
    for (int i = a; i <= b; i++) {
        if ((a + b + i) % 3 == 0) c++;
    }
    std::cout << c << std::endl;
}