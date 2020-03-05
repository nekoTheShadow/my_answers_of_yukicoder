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
	k := stdin.ReadInt()

	m := 6 * n
	dp1 := make([][]float64, n+1)
	dp2 := make([][]float64, n+1)
	for i := 0; i < n+1; i++ {
		dp1[i] = make([]float64, m+1)
		dp2[i] = make([]float64, m+1)
	}
	dp1[0][0] = 1.0
	dp2[0][0] = 1.0

	for i := 0; i < n; i++ {
		for j := 0; j < 6*n+1; j++ {
			if i < k {
				for d := 4; d <= 6; d++ {
					if j+d <= m {
						dp1[i+1][j+d] += dp1[i][j] * 2
					}
				}
			} else {
				for d := 1; d <= 6; d++ {
					if j+d <= m {
						dp1[i+1][j+d] += dp1[i][j]
					}
				}
			}
		}
	}

	for i := 0; i < n; i++ {
		for j := 0; j < 6*n+1; j++ {
			for d := 1; d <= 6; d++ {
				if j+d <= m {
					dp2[i+1][j+d] += dp2[i][j]
				}
			}
		}
	}

	sum := math.Pow(6, float64(n))
	ans := 0.0
	for i := 0; i <= m; i++ {
		for j := 0; j <= m; j++ {
			if i <= j {
				continue
			}
			ans += (dp1[n][i] / sum) * (dp2[n][j] / sum)
		}
	}
	stdout.Println(ans)
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
