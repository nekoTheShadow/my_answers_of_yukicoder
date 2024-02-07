use std::io::stdin;

fn main() {
    let mut line = String::new();
    stdin().read_line(&mut line).unwrap();
    let mut tokens = line.trim().split_whitespace();
    let n = tokens.next().unwrap().parse::<usize>().unwrap();
    let k = tokens.next().unwrap().parse::<usize>().unwrap();

    let mut is_prime = vec![true; n+1];
    is_prime[0] = false;
    is_prime[1] = false;
    for i in (2..=n).take_while(|v| v*v<=n) {
        if !is_prime[i] {
            continue;
        }
        for j in (i+i..=n).step_by(i) {
            is_prime[j] = false;
        }
    }

    let mut count = vec![0usize; n+1];
    for i in 0..=n {
        if !is_prime[i] {
            continue;
        }
        for j in (i..=n).step_by(i) {
            count[j] += 1
        }
    }
    println!("{}", count.iter().filter(|&&v| v>=k).count())
}


