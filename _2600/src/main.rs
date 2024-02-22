use std::io::stdin;

fn main() {
    let mut R = vec![0u128; 200000+1];
    let mut E = vec![0u128; 200000+1];
    R[1] = 1;
    R[2] = 1;
    E[1] = 1;
    E[2] = 3;
    for i in 3..200000+1 {
        R[i] = (R[i-1]+R[i-2])%998244353;
        E[i] = (E[i-1]+E[i-2])%998244353;
    }

    let Q = input();
    let N = (0..Q).map(|_| input()).collect::<Vec<_>>();
    for n in N {
        let mut ans = 1;
        ans *= (R[n]*R[n])%998244353;
        ans %= 998244353;
        ans *= 5;
        ans %= 998244353;

        ans += 998244353;
        ans -= (E[n]*E[n])%998244353;
        ans %= 998244353;
        
        println!("{}", ans);
    }
}

fn input() -> usize {
    let mut line = String::new();
    stdin().read_line(&mut line).unwrap();
    line.trim().parse::<_>().unwrap()
}
