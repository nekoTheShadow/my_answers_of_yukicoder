package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

func exec(stdin *Stdin, stdout *Stdout) {
	k := stdin.ReadInt()

	dp := make([][]float64, k+1)
	for i := 0; i < k+1; i++ {
		dp[i] = make([]float64, k)
	}
	dp[0][0] = 1.0

	cost := make([]float64, k+1)
	for i := 0; i < k+1; i++ {
		for j := 0; j < k; j++ {
			if dp[i][j] == 0.0 {
				continue
			}

			for d := 1; d <= 6; d++ {
				if j+d < k {
					dp[i+1][j+d] += dp[i][j]
				} else {
					cost[i+1] += dp[i][j]
				}
			}
		}
	}

	e := 0.0
	for i := 0; i < k+1; i++ {
		e += float64(i) * (cost[i] * (1.0 / math.Pow(6, float64(i))))
	}

	stdout.Println(e)
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
