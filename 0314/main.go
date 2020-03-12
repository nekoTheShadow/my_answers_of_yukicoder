package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

func exec(stdin *Stdin, stdout *Stdout) {
	n := stdin.ReadInt()

	// dp[最後][現在の場所] = 経路数
	//  - 最後=0 パー
	//  - 最後=1 ケンケン1
	//  - 最後=2 ケンケン2
	dp := make([][]int, 3)
	for i := 0; i < 3; i++ {
		dp[i] = make([]int, n+1)
	}
	dp[0][0] = 1

	mod := 1000000000 + 7
	for j := 0; j < n; j++ {
		for i := 0; i < 3; i++ {
			if i == 0 {
				dp[1][j+1] += dp[0][j]
				dp[1][j+1] %= mod
			}
			if i == 1 {
				dp[0][j+1] += dp[1][j]
				dp[2][j+1] += dp[1][j]
				dp[0][j+1] %= mod
				dp[2][j+1] %= mod
			}
			if i == 2 {
				dp[0][j+1] += dp[2][j]
				dp[0][j+1] %= mod
			}
		}
	}

	sum := 0
	for i := 0; i < 3; i++ {
		sum += dp[i][n]
		sum %= mod
	}
	stdout.Println(sum)
}

func main() {
	stdout := NewStdout()
	defer stdout.Flush()
	exec(NewStdin(bufio.ScanWords), stdout)
}

type Stdin struct {
	stdin *bufio.Scanner
}

func NewStdin(split bufio.SplitFunc) *Stdin {
	s := Stdin{bufio.NewScanner(os.Stdin)}
	s.stdin.Split(split)
	s.stdin.Buffer(make([]byte, bufio.MaxScanTokenSize), int(math.MaxInt32))
	return &s
}

func (s *Stdin) Read() string {
	s.stdin.Scan()
	return s.stdin.Text()
}

func (s *Stdin) ReadInt() int {
	n, _ := strconv.Atoi(s.Read())
	return n
}

func (s *Stdin) ReadFloat64() float64 {
	n, _ := strconv.ParseFloat(s.Read(), 64)
	return n
}

type Stdout struct {
	stdout *bufio.Writer
}

func NewStdout() *Stdout {
	return &Stdout{bufio.NewWriter(os.Stdout)}
}

func (s *Stdout) Flush() {
	s.stdout.Flush()
}

func (s *Stdout) Println(a ...interface{}) {
	fmt.Fprintln(s.stdout, a...)
}
