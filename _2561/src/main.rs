use std::io::stdin;

fn main() {
    let nk = read();
    let n = nk[0];
    let k = nk[1];
    let a = read();

    // bit, cur, tot
    let mut c = 0;
    let mut stack = (0..n).map(|i| 1u128 << i).collect::<Vec<_>>();
    while !stack.is_empty() {
        let bit = stack.pop().unwrap();
        if bit.count_ones() as usize == k {
            let mut t1 = 0;
            let mut t2 = 0;
            for i in 0..n {
                if bit & (1 << i) != 0 {
                    t1 = (t1 + a[i]) % 998;
                    t2 = (t2 + a[i]) % 998244353;
                }
            }
            if t2 <= t1 {
                c = (c + 1) % 998;
            }
            continue;
        }
        for i in (0..n).rev() {
            if bit & (1 << i) != 0 {
                break;
            }
            stack.push(bit | (1 << i));
        }
    }
    println!("{}", c);
}

fn read() -> Vec<usize> {
    let mut line = String::new();
    stdin().read_line(&mut line).unwrap();
    line.split_whitespace()
        .map(|token| token.parse().unwrap())
        .collect::<Vec<_>>()
}
