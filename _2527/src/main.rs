use std::{cmp::max, io::stdin};

fn main() {
    let mut line = String::new();
    stdin().read_line(&mut line).unwrap();
    let mut tokens = line
        .split_whitespace()
        .map(|token| token.parse::<usize>().unwrap());
    let h = tokens.next().unwrap();
    let w = tokens.next().unwrap();
    let k = tokens.next().unwrap();

    let m = 998244353;
    let mut mncr = ModuloNCR::new(max(h, w), m);
    let mut ret = 0;
    for a in 0..=w {
        if w - a > 0 && k % (w - a) == 0 && h >= k / (w - a) {
            let b = h - k / (w - a);
            ret += mncr.ncr(h, b) * mncr.ncr(w, a);
            ret %= m;
        }
    }
    println!("{}", ret);
}

struct ModuloNCR {
    f: Vec<usize>,
    g: Vec<usize>,
    m: usize,
}

impl ModuloNCR {
    pub fn new(n: usize, m: usize) -> Self {
        let mut f = vec![0; n + 1];
        let mut g = vec![0; n + 1];
        let mut t = vec![0; n + 1];
        f[0] = 1;
        f[1] = 1;
        g[0] = 1;
        g[1] = 1;
        t[1] = 1;
        for i in 2..=n {
            f[i] = f[i - 1] * i % m;
            t[i] = m - t[m % i] * (m / i) % m;
            g[i] = g[i - 1] * t[i] % m;
        }
        ModuloNCR { f, g, m }
    }

    pub fn ncr(&mut self, n: usize, r: usize) -> usize {
        self.f[n] * (self.g[r] * self.g[n - r] % self.m) % self.m
    }
}
