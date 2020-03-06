package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

func exec(stdin *Stdin, stdout *Stdout) {
	n := stdin.ReadInt()
	m := stdin.ReadInt()
	k := stdin.ReadInt()

	a := make([]int, m)
	b := make([]int, m)
	c := make([]int, m)
	for i := 0; i < m; i++ {
		a[i] = stdin.ReadInt() - 1
		b[i] = stdin.ReadInt() - 1
		c[i] = stdin.ReadInt()
	}

	d := make([]int, k)
	for i := 0; i < k; i++ {
		d[i] = stdin.ReadInt()
	}

	dp := make([][]bool, k+1)
	for i := 0; i <= k; i++ {
		dp[i] = make([]bool, n)
	}
	for i := 0; i < n; i++ {
		dp[0][i] = true
	}

	for i := 0; i < k; i++ {
		for j := 0; j < n; j++ {
			if !dp[i][j] {
				continue
			}

			for x := 0; x < m; x++ {
				if c[x] != d[i] {
					continue
				}
				if b[x] == j {
					dp[i+1][a[x]] = true
				}
				if a[x] == j {
					dp[i+1][b[x]] = true
				}
			}
		}
	}

	first := 0
	second := []string{}
	for i := 0; i < n; i++ {
		if !dp[k][i] {
			continue
		}
		first++
		second = append(second, strconv.Itoa(i+1))
	}
	stdout.Println(first)
	stdout.Println(strings.Join(second, " "))
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
