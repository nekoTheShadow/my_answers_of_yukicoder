#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#include<map>
#include<numeric>

int main() {
    int n;
    std::cin >> n;

    std::vector<std::string> s(n), id(n);
    for (int i = 0; i < n; i++) std::cin >> s[i] >> id[i];

    std::map<std::string, int> t;
    t["iti"] = 1;
    t["ni"]  = 2;
    t["san"] = 3;
    t["yon"] = 4;

    std::vector<int> indexes(n);
    std::iota(indexes.begin(), indexes.end(), 0);
    std::sort(indexes.begin(), indexes.end(), [&](int i1, int i2){
        if (s[i1] == s[i2]) {
            return t[id[i1]] < t[id[i2]];
        } else {
            return s[i1] < s[i2];
        }
    });

    for (int i : indexes) std::cout << s[i] << " " << id[i] << std::endl;
}