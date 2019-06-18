fn main() {
    let (l, r, n): (i128, i128, i128) = {
        let mut s = String::new();
        std::io::stdin().read_line(&mut s).ok();
        let mut i = s.trim().split_whitespace().map(|e| e.parse().unwrap());
        (i.next().unwrap(), i.next().unwrap(), i.next().unwrap())
    };

    for i in 0..n {
        let min = if l % n == i {
            l
        } else {
            let x = (l / n) * n + i;
            let y = (l / n + 1) * n + i;
            if l <= x { 
                x
            } else {
                y
            }
        };

        let max = if r % n == i {
            r
        } else {
            let x = (r / n) * n + i;
            let y = (r / n - 1) * n + i;
            if x <= r {
                x
            } else {
                y
            }
        };
        
        println!("{}", (max - min) / n + 1)
    }
}
