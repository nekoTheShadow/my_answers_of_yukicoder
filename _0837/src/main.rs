fn main() {
    let n: usize = {
        let mut s = String::new();
        std::io::stdin().read_line(&mut s).ok();
        s.trim().parse().unwrap()
    };
    let mut y: Vec<i128> = {
        let mut s = String::new();
        std::io::stdin().read_line(&mut s).ok();
        s.trim().split_whitespace().map(|e| e.parse().unwrap()).collect()
    };

    y.sort();
    let mut dp = vec![0; n + 1];
    for i in 0..n {
        dp[i + 1] = dp[i] + y[i]; 
    }
    
    let ans = if y[0] == y[n - 1] {
        1
    } else {
        let mut min = std::i128::MAX;
        for i in 0..n {
            min = std::cmp::min(min, sum(&mut dp, 0, i) + sum(&mut dp, i, n));
        }
        min
    };
    println!("{}", ans);
}

fn sum(dp: &mut Vec<i128>, l: usize, r: usize) -> i128 {
    let m = (r + l) / 2;
    let x = dp[m] - dp[l];
    let y = if (r - l) % 2 == 0 {
        dp[r] - dp[m]
    } else {
        dp[r] - dp[m + 1]
    };
    y - x
}

