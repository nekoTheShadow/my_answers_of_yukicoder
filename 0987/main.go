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
	op := stdin.Read()
	a := []int{}
	b := []int{}
	for i := 0; i < m; i++ {
		b = append(b, stdin.ReadInt())
	}
	for i := 0; i < n; i++ {
		a = append(a, stdin.ReadInt())
	}

	s := make([][]int, n)
	for i := 0; i < n; i++ {
		s[i] = make([]int, m)
	}

	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if op == "+" {
				s[i][j] = a[i] + b[j]
			} else {
				s[i][j] = a[i] * b[j]
			}
		}
	}

	for i := 0; i < n; i++ {
		t := []string{}
		for j := 0; j < m; j++ {
			t = append(t, strconv.Itoa(s[i][j]))
		}
		stdout.Println(strings.Join(t, " "))
	}
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
