use std::{
    collections::{HashMap, HashSet},
    io::stdin,
};

fn main() {
    let nm = input();
    let n = nm[0];
    let m = nm[1];
    let c = input();

    let mut uf = UnionFind::new(n);
    for _ in 0..m {
        let uv = input();
        let u = uv[0] - 1;
        let v = uv[1] - 1;
        if c[u] == c[v] {
            uf.union(u, v);
        }
    }

    let mut map = HashMap::new();
    for i in 0..n {
        map.entry(c[i])
            .or_insert_with(|| HashSet::new())
            .insert(uf.find(i));
    }

    let ret = map.iter().map(|(_k, v)| v.len() - 1).sum::<usize>();
    println!("{}", ret);
}

fn input() -> Vec<usize> {
    let mut buf = String::new();
    stdin().read_line(&mut buf).unwrap();
    buf.split_whitespace()
        .map(|token| token.parse().unwrap())
        .collect::<Vec<usize>>()
}

pub struct UnionFind {
    parent: Vec<usize>,
}

impl UnionFind {
    pub fn new(n: usize) -> Self {
        let parent = (0..n).collect::<Vec<_>>();
        UnionFind { parent }
    }

    pub fn find(&mut self, x: usize) -> usize {
        if self.parent[x] == x {
            return x;
        }
        self.parent[x] = self.find(self.parent[x]);
        self.parent[x]
    }

    pub fn union(&mut self, x: usize, y: usize) {
        let x = self.find(x);
        let y = self.find(y);
        if x != y {
            self.parent[x] = y;
        }
    }
}
