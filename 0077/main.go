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
	a := make([]int, n)
	for i := 0; i < n; i++ {
		a[i] = stdin.ReadInt()
	}

	sum := 0
	for _, v := range a {
		sum += v
	}

	m := 1
	for {
		t := (m/2 + 1) * (m/2 + 1)
		if t == sum {
			break
		}
		if sum < t {
			m -= 2
			break
		}
		m += 2
	}

	p := make([]int, m)
	p[0] = 1
	for i := 1; i < m; i++ {
		if i <= m/2 {
			p[i] = p[i-1] + 1
		} else {
			p[i] = p[i-1] - 1
		}
	}

	for len(a) < m {
		a = append(a, 0)
	}
	for len(p) < n {
		p = append(p, 0)
	}

	ans := 0
	for i := 0; i < len(a); i++ {
		if p[i] < a[i] {
			ans += a[i] - p[i]
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
