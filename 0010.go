package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

func main() {
	n := readInt()
	t := readInt()
	a := make([]int, n)
	for i := 0; i < n; i++ {
		a[i] = readInt()
	}

	dp := make([]map[int]string, n)
	for i := 0; i < n; i++ {
		dp[i] = make(map[int]string)
	}
	dp[0][a[0]] = ""

	for i := 1; i < n; i++ {
		for k := range dp[i-1] {
			if k*a[i] <= t {
				dp[i][k*a[i]] = max(dp[i][k*a[i]], dp[i-1][k]+"*")
			}
			if k+a[i] <= t {
				dp[i][k+a[i]] = max(dp[i][k+a[i]], dp[i-1][k]+"+")
			}
		}
	}

	fmt.Println(dp[n-1][t])
}

func max(x string, y string) string {
	if x < y {
		return y
	} else {
		return x
	}
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
