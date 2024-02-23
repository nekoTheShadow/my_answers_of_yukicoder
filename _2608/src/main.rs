use std::io::stdin;

fn main() {
    let T = input();
    for _ in 0..T {
        let N = input();
        let sum = ((1+N)*N)/2;
        if sum%2!=0 {
            println!("{}", -1);
            continue;
        }

        let mut stack = vec![(1u128, 0u128, 0u128)]; // cur, bit
        while !stack.is_empty() {
            let (cur, bit, tot) = stack.pop().unwrap();
            if tot==sum/2 {
                let ret = (1..=N).map(|i| if bit&(1<<i)==0{"0"}else{"1"}).collect::<Vec<_>>().concat();
                println!("{}", ret);
                break;
            }
            if tot>sum/2 || cur==N+1 {
                continue;
            }
            // curを採用しない
            stack.push((cur+1, bit, tot));

            // curを採用する
            stack.push((cur+1, bit|(1<<cur), tot+cur));
        }
    }
}


fn input() -> u128 {
    let mut line = String::new();
    stdin().read_line(&mut line).unwrap();
    line.trim().parse::<>().unwrap()
}