fn main() {
    let n: i32 = {
        let mut s = String::new();
        std::io::stdin().read_line(&mut s).ok();
        s.trim().parse().unwrap()
    };

    println!("{}", n + n / 2);
}
