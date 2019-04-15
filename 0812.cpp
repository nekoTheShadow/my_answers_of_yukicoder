#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<cmath>

int main() {
    int n, m;
    std::cin >> n >> m;

    std::vector<std::vector<int>> nxts(n, std::vector<int>());
    for (int i = 0; i < m; i++) {
        int p, q;
        std::cin >> p >> q;
        p--;
        q--;
        nxts[p].push_back(q);
        nxts[q].push_back(p);
    }

    int q;
    std::cin >> q;

    for (int i = 0; i < q; i++) {
        int a;
        std::cin >> a;
        a--;

        int inf = 1000000007;
        std::vector<int> d(n, inf);
        d[a] = 0;
        std::queue<int> que;
        que.push(a);
        while(!que.empty()){
            int x = que.front();
            que.pop();
            for (auto&& y : nxts[x]) {
                if (d[x] + 1 < d[y]) {
                    d[y] = d[x] + 1;
                    que.push(y); 
                }
            }
        }

        int b = 0;
        int c = 0;
        for (auto&& v : d) {
            if (v != 0 && v != inf) {
                b++;
                c = std::max(c, v);
            }
        }

        if (c == 0) {
            std::cout << b << " " << c << std::endl;
        } else {
            std::cout << b << " " << std::ceil(std::log2(c)) << std::endl;
        }
    }
} 