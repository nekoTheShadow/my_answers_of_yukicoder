package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

func exec(stdin *Stdin, stdout *Stdout) {
	d := map[rune]int{}
	for ch := 'a'; ch <= 'z'; ch++ {
		d[ch] = stdin.ReadInt()
	}

	if d['h'] < 1 || d['e'] < 1 || d['w'] < 1 || d['r'] < 1 || d['d'] < 1 || d['l'] < 3 || d['o'] < 2 {
		stdout.Println(0)
		return
	}

	// l
	lmax := 0
	for i := 0; i <= d['l']; i++ {
		j := d['l'] - i
		if i < 2 || j < 1 {
			continue
		}
		lmax = Max(lmax, i*(i-1)/2*j)
	}

	omax := 0
	for i := 0; i <= d['o']; i++ {
		j := d['o'] - i
		if i < 1 || j < 1 {
			continue
		}
		omax = Max(omax, i*j)
	}

	sum := 1
	sum *= d['h']
	sum *= d['e']
	sum *= d['w']
	sum *= d['r']
	sum *= d['d']
	sum *= lmax
	sum *= omax
	stdout.Println(sum)
}

func Max(a ...int) int {
	v := a[0]
	for i := 1; i < len(a); i++ {
		if v < a[i] {
			v = a[i]
		}
	}
	return v
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

func Min(a ...int) int {
	v := a[0]
	for i := 1; i < len(a); i++ {
		if a[i] < v {
			v = a[i]
		}
	}
	return v
}
