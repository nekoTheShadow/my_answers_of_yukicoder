package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

func main() {
	a := make([]int, 5)
	for i := 4; i >= 0; i-- {
		a[i] = readInt()
	}

	ans := make([]int, 0)
	for fib1, fib2 := 1, 1; fib1 <= a[0]; fib1, fib2 = fib2, fib1+fib2 {
		if a[0] == fib1 {
			c := 0
			x := fib1
			y := fib2
			for j := 0; j < len(a); j++ {
				if a[j] == x {
					c++
					x, y = y, x+y
				} else {
					break
				}
			}
			ans = append(ans, c)
		}
	}

	max := 0
	for _, v := range ans {
		if max < v {
			max = v
		}
	}
	fmt.Println(max)
}

var stdin *bufio.Scanner

func read() string {
	if stdin == nil {
		stdin = bufio.NewScanner(os.Stdin)
		stdin.Split(bufio.ScanWords)
		stdin.Buffer(make([]byte, bufio.MaxScanTokenSize), int(math.MaxInt32))
	}
	stdin.Scan()
	return stdin.Text()
}

func readInt() int {
	n, _ := strconv.Atoi(read())
	return n
}
