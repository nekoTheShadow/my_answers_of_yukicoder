use std::io::stdin;

fn main() {
    let N = input().parse::<usize>().unwrap();
    let A = input().split_whitespace().map(|t| t.parse::<usize>().unwrap()).collect::<Vec<_>>();

    let mut x = N;
    let mut c = 0;
    for &a in A.iter().rev() {
        if x==a {
            c += 1;
            x -= 1;
        }
    }
    println!("{}", N-c);
}

fn input() -> String {
    let mut buf = String::new();
    stdin().read_line(&mut buf).unwrap();
    buf.trim().to_string()
}
