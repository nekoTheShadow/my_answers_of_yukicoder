package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

func exec(stdin *Stdin, stdout *Stdout) {
	n = stdin.ReadInt()
	w = make([]int, n)
	for i := 0; i < n; i++ {
		w[i] = stdin.ReadInt()
	}
	m = stdin.ReadInt()
	b = make([]int, m)
	for i := 0; i < m; i++ {
		b[i] = stdin.ReadInt()
	}

	ans := 0
	for i := 0; i < n; i++ {
		ans = Max(ans, f(i, false))
	}
	for i := 0; i < m; i++ {
		ans = Max(ans, f(i, true))
	}
	stdout.Println(ans + 1)
}

var n, m int
var w, b []int

func f(x int, black bool) int {
	ans := 0
	if black {
		for i := 0; i < n; i++ {
			if w[i] < b[x] {
				ans = Max(ans, f(i, false)+1)
			}
		}
	} else {
		for i := 0; i < m; i++ {
			if b[i] < w[x] {
				ans = Max(ans, f(i, true)+1)
			}
		}
	}
	return ans
}

func Max(a int, b ...int) int {
	for _, v := range b {
		if a < v {
			a = v
		}
	}
	return a
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
