#include<iostream>

int main() {
    long double xa, ya, xb, yb;
    std::cin >> xa >> ya >> xb >> yb;
    long double yp = (yb * xa+ ya * xb)/(xa + xb);
    std::cout << std::fixed << yp << std::endl;
}