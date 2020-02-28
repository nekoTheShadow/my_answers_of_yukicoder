package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	stdin := bufio.NewScanner(os.Stdin)
	stdin.Split(bufio.ScanWords)
	n, _ := strconv.ParseUint(read(stdin), 10, 64)
	m := 316 + (n-1)*52
	fmt.Println(m)
}

func read(stdin *bufio.Scanner) string {
	stdin.Scan()
	return stdin.Text()
}
