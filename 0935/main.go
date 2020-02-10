package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
	"strconv"
)

func exec(stdin *Stdin, stdout *Stdout) {
	n := stdin.ReadInt()
	s := stdin.Read()
	a := []int{}
	for i := 0; i < n; i++ {
		a = append(a, stdin.ReadInt())
	}
	q := stdin.ReadInt()
	k := []int{}
	for i := 0; i < q; i++ {
		k = append(k, stdin.ReadInt())
	}

	// key = 倒せる数、エネルギー
	d := make([]int, n+1)
	for i := 1; i < n+1; i++ {
		d[i] = int(math.MaxInt32)
	}
	for i := 0; i < n; i++ {
		key := 0
		val := 0
		for j := i; j < n; j++ {
			if s[j] == 'E' {
				key++
			}
			val += a[j]
			d[key] = Min(d[key], val)
		}
	}

	for i := n - 1; i >= 0; i-- {
		key := 0
		val := 0
		for j := i; j >= 0; j-- {
			if s[j] == 'E' {
				key++
			}
			val += a[j]
			d[key] = Min(d[key], val)
		}
	}

	for i := 0; i < q; i++ {
		x := sort.Search(n+1, func(j int) bool {
			return d[j] > k[i]
		})
		stdout.Println(x - 1)
	}
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
