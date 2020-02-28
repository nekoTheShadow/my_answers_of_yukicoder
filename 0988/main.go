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

	if op == "+" {
		sum1 := 0
		sum2 := 0
		for _, v := range a {
			sum1 += v % k
			sum1 %= k
		}
		for _, v := range b {
			sum2 += v % k
			sum2 %= k
		}

		stdout.Println((sum1*m%k + sum2*n%k) % k)
	} else {
		sum := 0
		for _, v := range a {
			sum += v % k
			sum %= k
		}

		ans := 0
		for _, v := range b {
			ans += sum * v % k
			ans %= k
		}
		stdout.Println(ans)
	}
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
