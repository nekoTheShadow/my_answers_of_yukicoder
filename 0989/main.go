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
	m := stdin.ReadInt()
	k := stdin.ReadInt()
	op := stdin.Read()
	a := []int{}
	b := []int{}
	for i := 0; i < m; i++ {
		b = append(b, stdin.ReadInt())
	}
	for i := 0; i < n; i++ {
		a = append(a, stdin.ReadInt())
	}

	sort.Ints(a)
	ans := 0
	if op == "+" {
		for i := 0; i < m; i++ {
			p := sort.Search(n, func(x int) bool {
				return a[x] >= k-b[i]
			})
			ans += n - p
		}
	} else {
		for i := 0; i < m; i++ {
			p := sort.Search(n, func(x int) bool {
				return a[x] >= CeilDiv(k, b[i])
			})
			ans += n - p
		}
	}

	stdout.Println(ans)
}

func Gcd(x, y int) int {
	if x < y {
		x, y = y, x
	}

	for y > 0 {
		x, y = y, x%y
	}

	return x
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

func CeilDiv(x, y int) int {
	if x%y == 0 {
		return x / y
	} else {
		return x/y + 1
	}
}
