#include<iostream>
#include<string>

int main() {
    int n;
    std::string s;
    std::cin >> n;
    std::cin >> s;

    int ans = 0;
    for (int i = 0, len = s.size(); i < len; i++) {
        if (s[i] != 'U') continue;
        for (int j = i + 1; j < len; j++) {
            if (s[j] != 'M') continue;
            int k = j + (j - i);
            if (len <= k) break;
            if (s[k] == 'G') ans++;
        }
    }

    std::cout << ans << std::endl;
}