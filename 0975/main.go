package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

func exec(stdin *Stdin, stdout *Stdout) {
	x := stdin.ReadInt()
	n := stdin.ReadInt()
	m := stdin.ReadInt()

	a := map[int]bool{}
	b := map[int]bool{}
	for i := 0; i < n; i++ {
		a[stdin.ReadInt()] = true
	}
	for i := 0; i < m; i++ {
		b[stdin.ReadInt()] = true
	}

	_, ok1 := a[x]
	_, ok2 := b[x]
	if ok1 && ok2 {
		stdout.Println("MrMaxValu")
	} else if ok1 && !ok2 {
		stdout.Println("MrMax")
	} else if !ok1 && ok2 {
		stdout.Println("MaxValu")
	} else {
		stdout.Println(-1)
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
