#include<iostream>
#include<vector>
#include<set>

struct unionfind {
    std::vector<int> parent;

    unionfind(int n) {
        for (int i = 0; i < n; i++) parent.push_back(i);
    }

    int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    void unite(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }
};

int main() {
    int h, w;
    std::cin >> h >> w;
    std::vector<std::vector<int>> a(h, std::vector<int>(w));
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) std::cin >> a[i][j];
    }

    auto uf = unionfind(h * w);
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            if (a[i][j] == 0) continue;
            if (i + 1 < h && a[i + 1][j] == 1) uf.unite(w * i + j, w * (i + 1) + j);
            if (j + 1 < w && a[i][j + 1] == 1) uf.unite(w * i + j, w * i + (j + 1));
        }
    }

    std::set<int> s;
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            if (a[i][j] == 1) {
                s.insert(uf.find(w * i + j));
            }
        }
    }

    std::cout << s.size() << std::endl;
}