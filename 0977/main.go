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
	uf := NewUnionFind(n)
	d := make([]int, n)
	for i := 0; i < n-1; i++ {
		u := stdin.ReadInt()
		v := stdin.ReadInt()
		uf.Union(u, v)
		d[u]++
		d[v]++
	}

	m := map[int]int{}
	for i := 0; i < n; i++ {
		k := uf.Find(i)
		if _, ok := m[k]; ok {
			m[k]++
		} else {
			m[k] = 1
		}
	}

	if len(m) == 1 {
		stdout.Println("Bob")
	} else if len(m) == 2 {
		isAlice := false
		for _, v := range d {
			if v == 1 {
				isAlice = true
			}
		}
		if isAlice {
			stdout.Println("Alice")
		} else {
			stdout.Println("Bob")
		}
	} else {
		stdout.Println("Alice")
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

type UnionFind struct {
	parents []int
}

func NewUnionFind(n int) *UnionFind {
	uf := UnionFind{}
	uf.parents = []int{}
	for i := 0; i < n; i++ {
		uf.parents = append(uf.parents, i)
	}
	return &uf
}

func (uf *UnionFind) Find(x int) int {
	if uf.parents[x] == x {
		return x
	}

	uf.parents[x] = uf.Find(uf.parents[x])
	return uf.parents[x]
}

func (uf *UnionFind) Union(x, y int) {
	x = uf.Find(x)
	y = uf.Find(y)
	if x != y {
		uf.parents[y] = x
	}
}
