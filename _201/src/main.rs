use std::io::stdin;

fn main() {
    let (sa, pa, _xa) = readline();
    let (sb, pb, _xb) = readline();

    if pa.len() == pb.len() {
        if pa > pb {
            println!("{}", sa);
        } else if pa < pb {
            println!("{}", sb);
        } else {
            println!("{}", -1);
        }
    } else if pa.len() > pb.len() {
        println!("{}", sa);
    } else {
        println!("{}", sb);
    }
}

fn readline() -> (String, String, String) {
    let mut line = String::new();
    stdin().read_line(&mut line).ok();
    let mut tokens = line.split_whitespace();
    let a = tokens.next().unwrap().to_string();
    let b = tokens.next().unwrap().to_string();
    let c = tokens.next().unwrap().to_string();
    (a, b, c)
}
